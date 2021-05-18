package ru.compas;

import ru.compas.Enemy.Enemy;
import ru.compas.Enemy.EnemyController;
import ru.compas.backpack.Backpack;
import ru.compas.collision.CollisionKarta;
import ru.compas.collision.CollisionObject;
import ru.compas.collision.CollisionUtils;
import ru.compas.collision.Palka;
import ru.compas.network.Client;
import ru.compas.objects.Castle;
import ru.compas.objects.CastleController;
import ru.compas.objects.Domik;
import ru.compas.objects.Vzbuchka;
import ru.compas.network.Server;
import ru.compas.things.Artefact;
import ru.compas.things.ArtefactContloller;
import ru.compas.things.Coin;
import ru.compas.things.*;
import ru.compas.utils.Utils;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;


public class controller {

    static int TOP_BORDER = 250;
    static int LEFT_BORDER = 250;
    static int RIGHT_BORDER = 750;
    static int BOTTOM_BORDER = 750;
    static boolean shouldMoveMaps;


    static boolean blockUp = false;
    static boolean blockDown = false;
    static boolean blockRight = false;
    static boolean blockLeft = false;

    static boolean motion = true;
    static boolean blockNow = false;

    static int coins = 0;
    static int swords = 0;
    static int bows = 0;

    static ArrayList<Vzbuchka> vzbuchka_list = new ArrayList<>();


    public controller(JFrame frame, Pers player, ArrayList<MapLocation> maps) {

        RIGHT_BORDER = frame.getWidth() - 250 - player.getWidth();
        BOTTOM_BORDER = frame.getHeight() - 250;

        Timer right = timer(maps, player, "right");
        Timer left = timer(maps, player, "left");
        Timer down = timer(maps, player, "toward");
        Timer up = timer(maps, player, "forward");

        JFrame casframe = new JFrame();
        casframe.setSize(1000,1000);
        casframe.setLayout(null);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                RIGHT_BORDER = frame.getWidth() - 250 - player.getWidth();
                BOTTOM_BORDER = frame.getHeight() - 250;

                if ((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)) {
                    if (!blockUp) {
                        up.start();
                    }
                } else if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)) {
                    if (!blockDown) {
                        down.start();
                    }
                } else if ((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)) {
                    if (!blockLeft) {
                        left.start();
                    }
                } else if ((e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)) {
                    if (!blockRight) {
                        right.start();
                    }
                }
            }


            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if ((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)) {
                    up.stop();
                } else if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)) {
                    down.stop();
                } else if ((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)) {
                    left.stop();
                } else if ((e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)) {
                    right.stop();
                }
                else if (e.getKeyCode() == KeyEvent.VK_E) {
                    check_distance(player, CastleController.label, Combo_General.map, casframe);
                }
            }
        });

    }

    static void shouldMapMove(Pers player, String direction) {
        int x = player.getX();
        int y = player.getY();

        if (direction.equals("right") && x < RIGHT_BORDER || direction.equals("left") && x > LEFT_BORDER || direction.equals("toward") && y < BOTTOM_BORDER || direction.equals("forward") && y > TOP_BORDER) {
            player.move(direction);
            shouldMoveMaps = false;
        } else {
            shouldMoveMaps = true;
        }

    }

    static void palkaFor (ArrayList<MapLocation> maps, Pers player, int addx, int addy, Timer timer) {
        int x = player.getX();
        int y = player.getY();
        for (int i = 0; i < maps.size(); i++) {
            MapLocation map = maps.get(i);
            for (int j = 0; j < map.getKarta().palki.size(); j++) {
                Palka palka = map.getKarta().palki.get(j);
                if (CollisionUtils.isPersAndPalkaIntersected(player, palka, map, true)) {
                    player.move("stop");
                    player.setLocation(x + addx, y + addy);
                    shouldMoveMaps = false;
                    blockNow = true;
                    timer.stop();
                    break;
                }
            }
        }
    }
    static void checkCollision(ArrayList<MapLocation> maps, Pers player, int addx, int addy, Timer timer) {
        int x = player.getX();
        int y = player.getY();
        boolean notIntersected = true;
        for (int j = 0; j < maps.size(); j++) {
            MapLocation mapLocation = maps.get(j);
            //
            for (int i = 0; i < mapLocation.getCollisionObjects().size(); i++) {
                CollisionObject object = mapLocation.getCollisionObjects().get(i);
                for (int k = 0; k < object.karta.palki.size(); k++) {
                    Palka palka = object.karta.palki.get(k);
                    if (CollisionUtils.isPersAndPalkaIntersected(player, palka, mapLocation, true)) {
                        if (object instanceof Enemy) {
                            object.setVisible(false);

                            if (((Enemy) object).agressive_timer != null) {
                                ((Enemy) object).agressive_timer.stop();
                            }

                            if (((Enemy) object).voskl_znak !=null){
                                mapLocation.remove(((Enemy) object).voskl_znak);
                            }

                            mapLocation.getCollisionObjects().remove(object);
                            player.setVisible(false);

                            Vzbuchka draka1 = new Vzbuchka(player.getX(), player.getY(),
                                    ((Enemy) object).life, ((Enemy) object).strong, player.hp, player.strong, ((Enemy) object));

                            draka1.vzbuchka_controller();
                            vzbuchka_list.add(draka1);
                            Combo_General.pane.add(draka1);
                            motion = false;
                            Combo_General.pane.setLayer(draka1, 1);
                            Combo_General.frame.repaint();
                            notIntersected = false;
                        } else {
                            System.out.println("tuck");


                        }

                        player.move("stop");
                        player.setLocation(x + addx, y + addy);
                        shouldMoveMaps = false;
                        blockNow = true;
                        timer.stop();
                        break;
                    }
                }

                    if (notIntersected){
                        player.setVisible(true);
                        motion = true;
                        for (int a = 0; a < vzbuchka_list.size(); a++){
                            Vzbuchka vz = vzbuchka_list.get(a);
                            vz.end_vzbuchka();
                            Combo_General.pane.remove(vz);
                            if (vz.enemy.life > 0) {

                                Thread thread = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        vz.enemy.setVisible(true);
//                            vz.enemy.agressive_timer.start();
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        EnemyController.setPassiveMode(vz.enemy, mapLocation);
                                        mapLocation.getCollisionObjects().add(vz.enemy);
                                    }
                                });

                                thread.start();

                            }else{
                                mapLocation.getCollisionObjects().remove(vz.enemy);
                                if (vz.enemy.voskl_znak != null){
                                    mapLocation.remove(vz.enemy.voskl_znak);
                                }
                            }


                            CounterController.set_life_indikator();
                        }
                        vzbuchka_list.clear();
                    }


            }

        }
    }
        static void MapMoves (ArrayList<MapLocation> maps, Pers player, int addX, int addY) {
                for (int i = 0; i < maps.size(); i++) {
                    JLabel map = maps.get(i);
                    int MAP_X = map.getX();
                    int MAP_Y = map.getY();
                    map.setLocation(MAP_X + addX , MAP_Y + addY);

            }

        for (int a = 0; a < Combo_General.list_players.size(); a++) {
            if (!(Combo_General.list_players.get(a).unique_code).equals("I")) {
                int x = Combo_General.list_players.get(a).getX();
                int y = Combo_General.list_players.get(a).getY();
                x = x + addX;
                y = y + addY;
                Combo_General.list_players.get(a).setLocation(x, y);
            }
        }
    }

        static Timer timer (ArrayList<MapLocation> maps, Pers player, String direction) {

        Timer timer = new Timer(30, null);
        timer.addActionListener(new ActionListener() {
            int addx = 0;
            int addy = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                int addX = 0;
                int addY = 0;
                blockNow = false;

                if (motion) {
                    if (direction.equals("right")) {
                        addX = -player.velocity;
                        blockRight = blockNow;
                        addx = -20;
                    } else if (direction.equals("left")) {
                        addX = player.velocity;
                        blockLeft = blockNow;
                        addx = 20;
                    } else if (direction.equals("forward")) {
                        addY = player.velocity;
                        blockUp = blockNow;
                        addy = 20;
                    } else if (direction.equals("toward")) {
                        addY = -player.velocity;
                        blockDown = blockNow;
                        addy = -20;
                    }

                } else {

                }

                shouldMapMove(player, direction);
                checkCollision(maps, player, addx, addy, timer);
                palkaFor(maps, player, addx, addy, timer);

                if (shouldMoveMaps) {
                    MapMoves(maps, player, addX, addY);
                }
                player.mapX = maps.get(0).getX();
                player.mapY = maps.get(0).getY();

                pickUpArtefacts(player, maps);

                if (!Combo_General.isServer) {
                    try {
                        String s = player.getX() + "*" + player.getY() + " " + maps.get(0).getX() + "@" + maps.get(0).getY()
                                + "#" + player.name_img;
                        Client.send_to_server(s);
                    } catch (IOException IOException) {
                        IOException.printStackTrace();
                    }
                } else{
                    try {
                        int x = Combo_General.list_players.get(0).getX();
                        int y = Combo_General.list_players.get(0).getY();

                        Combo_General.list_players.get(0).XNotChange = x;
                        Combo_General.list_players.get(0).YNotChange = y;

                        Server.rassilka();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });
        return timer;
    }


    static void pickUpArtefacts(Pers player, ArrayList<MapLocation> maps) {
        // собираем артефакты

        for (int i = 0; i < maps.size(); i++) {
            MapLocation map = maps.get(i);
            for (int j = 0; j < map.artefacts.size(); j++) {
                Artefact artefact = map.artefacts.get(j);
                if (ArtefactContloller.isIntersected(player, artefact, map)) {
                    Utils.removeFromMap(artefact, map);
                    map.artefacts.remove(artefact);
                    Backpack.artefacts.add(artefact);
                    Combo_General.backpack.update();
                    if(artefact instanceof Coin){
                        coins ++;
                        CounterController.c++;
                    }
                    else if(artefact instanceof Sword){
                        swords++;
                        CounterController.s++;
                    }
                    else if(artefact instanceof Bow){
                        bows++;
                        CounterController.b++;
                    }
                    CounterController.kostil_counter_update();
                }
            }
        }
    }
    public static void check_distance(Pers player, JLabel label, MapLocation map, JFrame frame) {
        double d = Utils.distanceBetween(player, label, map, true);
        if (d < 200) {
            Combo_General.frame.setVisible(false);
            openLocation(frame);
            frame.add(player);
        }
    }

    public static void openLocation(JFrame frame) {
         frame.setVisible(true);
    }

    public static void move_other_players(Pers playerik, int x, int y, int mapX, int mapY) {

        playerik.XNotChange = x;
        playerik.YNotChange = y;

        System.out.println("MAP_OTH  " + mapX+  "  " + mapY);
        int IMapX = Combo_General.maps.get(0).getX();
        int IMapY = Combo_General.maps.get(0).getY();
        System.out.println("IMAP   " + IMapX + "  " + IMapY);
        int mapX_dob = -IMapX + mapX;
        int mapY_dob = -IMapY + mapY;
        System.out.println("MAPDOB  " + mapX_dob + "  " + +mapY_dob);

        x = x - mapX_dob;
        y = y - mapY_dob;
        System.out.println("XY  " + x + "  " + +y);
        playerik.setLocation(x, y);
        playerik.mapX = mapX;
        playerik.mapY = mapY;
        System.out.println("XY  "+  x+ "  " + +y);
        playerik.setLocation(x, y);
    }
}
