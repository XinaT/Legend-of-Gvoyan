package ru.compas;

import ru.compas.collision.CollisionObject;
import ru.compas.Messager.Dialog;
import ru.compas.collision.CollisionUtils;
import ru.compas.collision.Palka;
import ru.compas.network.Client;
import ru.compas.network.Server;
import ru.compas.things.Artefact;
import ru.compas.things.ArtefactContloller;

import javax.swing.*;
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

    static boolean blockNow = false;

    public controller(JFrame frame, player player, ArrayList<MapLocation> maps) {

        RIGHT_BORDER = frame.getWidth() - 250;
        BOTTOM_BORDER = frame.getHeight() - 250;

        Timer right = timer (maps, player, "right");
        Timer left = timer(maps, player, "left");
        Timer down = timer(maps, player, "toward");
        Timer up = timer(maps, player, "forward");

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

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

            }
        });

    }

        static void shouldMapMove (player player, String direction){
        int x = player.getX();
        int y = player.getY();

        if(direction.equals("right") && x < RIGHT_BORDER || direction.equals("left") && x > LEFT_BORDER || direction.equals("toward") && y < BOTTOM_BORDER || direction.equals("forward") && y > TOP_BORDER ){
            player.move(direction);
            shouldMoveMaps = false;
        }
        else {
            shouldMoveMaps = true;
        }

    }

    static void palkaFor (ArrayList<MapLocation> maps, player player, int addx, int addy, Timer timer) {
        int x = player.getX();
        int y = player.getY();
        for (int i = 0; i < maps.size(); i++) {
            MapLocation map = maps.get(i);
            for (int j = 0; j < map.karta.palki.size(); j++) {
                Palka palka = map.karta.palki.get(j);
                if (CollisionUtils.isPersAndPalkaIntersected(player, palka, map)) {
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
    static void checkCollision(ArrayList<MapLocation> maps, player player, int addx, int addy, Timer timer) {
        int x = player.getX();
        int y = player.getY();
        for (int j = 0; j < maps.size(); j++) {
            MapLocation mapLocation = maps.get(j);
            for (int i = 0; i < mapLocation.collisionObjects.size(); i++) {
                CollisionObject object = mapLocation.collisionObjects.get(i);
                for (int k = 0; k < object.karta.palki.size(); k++) {
                    Palka palka = object.karta.palki.get(k);
                    if (CollisionUtils.isPersAndPalkaIntersected(player, palka, mapLocation)) {
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
    }
        static void MapMoves (ArrayList<MapLocation> maps, player player, int addX, int addY) {
                for (int i = 0; i < maps.size(); i++) {
                    JLabel map = maps.get(i);
                    int MAP_X = map.getX();
                    int MAP_Y = map.getY();
                    map.setLocation(MAP_X + addX , MAP_Y + addY);

            }

            for (int a = 0; a < Combo_General.list_players.size(); a++){
                if (!(Combo_General.list_players.get(a).unique_code).equals("I")){
                    int x = Combo_General.list_players.get(a).getX();
                    int y = Combo_General.list_players.get(a).getY();
                    x = x + addX;
                    y = y + addY;
                    Combo_General.list_players.get(a).setLocation(x, y);
                }
            }
        }

        static Timer timer (ArrayList<MapLocation> maps, player player, String direction) {

        Timer timer = new Timer(30, null);
        timer.addActionListener(new ActionListener() {
            int addx = 0;
            int addy = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                int addX = 0;
                int addY = 0;
                blockNow = false;
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
                        String s = player.getX() + "*" + player.getY() + " " +maps.get(0).getX() + "@" + maps.get(0).getY();
                        Client.send_to_server(s);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                } else{
                    try {
                        Server.rassilka();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });
        return timer;
    }


    static void pickUpArtefacts(player player, ArrayList<MapLocation> maps) {
        // собираем артефакты

        for (int i = 0; i < maps.size(); i++) {
            MapLocation map = maps.get(i);
            for (int j = 0; j < map.artefacts.size(); j++) {
                Artefact artefact = map.artefacts.get(j);
                if (ArtefactContloller.isIntersected(player, artefact, map)) {
                    map.remove(artefact);
                }
            }
        }
    }

    public static void move_other_players(player playerik, int x, int y, int mapX, int mapY){
        System.out.println("MAP_OTH  " + mapX+  "  " + mapY);
        int IMapX = Combo_General.maps.get(0).getX();
        int IMapY = Combo_General.maps.get(0).getY();
        System.out.println("IMAP   " + IMapX + "  " + IMapY);
        int mapX_dob = -IMapX+mapX;
        int mapY_dob = -IMapY+mapY;
        System.out.println("MAPDOB  " + mapX_dob + "  "+ + mapY_dob);

        x = x - mapX_dob;
        y = y - mapY_dob;
        System.out.println("XY  "+  x+ "  " + +y);
        playerik.setLocation(x, y);
        playerik.mapX = mapX;
        playerik.mapY = mapY;
    }


}
