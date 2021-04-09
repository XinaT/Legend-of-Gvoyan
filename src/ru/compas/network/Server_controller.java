//package ru.compas.network;
//
//import ru.compas.Combo_General;
//import ru.compas.MapLocation;
//import ru.compas.collision.CollisionUtils;
//import ru.compas.collision.Palka;
//import ru.compas.network.Main_GENERAL_Server;
//import ru.compas.Player;
//import ru.compas.things.Artefact;
//import ru.compas.things.ArtefactContloller;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.util.ArrayList;
//
//public class Server_controller {
//
//    static int TOP_BORDER = 250;
//    static int LEFT_BORDER = 250;
//    static int RIGHT_BORDER = 750;
//    static int BOTTOM_BORDER = 750;
//    static boolean shouldMoveMaps;
//
//
//    static boolean blockUp = false;
//    static boolean blockDown = false;
//    static boolean blockRight = false;
//    static boolean blockLeft = false;
//
//    static boolean blockNow = false;
//
//    public Server_controller(JFrame frame, Player Player, ArrayList<MapLocation> maps) {
//
//        RIGHT_BORDER = frame.getWidth() - 250;
//        BOTTOM_BORDER = frame.getHeight() - 250;
//
//        Timer right = timer (maps, Player, "right");
//        Timer left = timer(maps, Player, "left");
//        Timer down = timer(maps, Player, "toward");
//        Timer up = timer(maps, Player, "forward");
//
//        frame.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                super.keyPressed(e);
//
//                if ((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)) {
//                    if (!blockUp) {
//                        up.start();
//                    }
//                } else if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)) {
//                    if (!blockDown) {
//                        down.start();
//                    }
//                } else if ((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)) {
//                    if (!blockLeft) {
//                        left.start();
//                    }
//                } else if ((e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)) {
//                    if (!blockRight) {
//                        right.start();
//                    }
//                }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                super.keyReleased(e);
//
//                if ((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)) {
//                    up.stop();
//                } else if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)) {
//                    down.stop();
//                } else if ((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)) {
//                    left.stop();
//                } else if ((e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)) {
//                    right.stop();
//                }
//
//            }
//        });
//
//    }
//
//    static void shouldMapMove (Player Player, String direction){
//        int x = Player.getX();
//        int y = Player.getY();
//
//        if(direction.equals("right") && x < RIGHT_BORDER || direction.equals("left") && x > LEFT_BORDER || direction.equals("toward") && y < BOTTOM_BORDER || direction.equals("forward") && y > TOP_BORDER ){
//            Player.move(direction);
//            shouldMoveMaps = false;
//        }
//        else {
//            shouldMoveMaps = true;
//        }
//
//    }
//
//    static void palkaFor (ArrayList<MapLocation> maps, Player Player, int addx, int addy, Timer timer) {
//        int x =Player.getX();
//        int y =Player.getY();
//        for (int i = 0; i < maps.size(); i++) {
//            MapLocation map = maps.get(i);
//            for (int j = 0; j < map.karta.palki.size(); j++) {
//                Palka palka = map.karta.palki.get(j);
//                if (CollisionUtils.isPersAndPalkaIntersected(Player, palka, map)) {
//                    Player.move("stop");
//                    Player.setLocation(x + addx,y + addy);
//                    shouldMoveMaps = false;
//                    blockNow = true;
//                    timer.stop();
//                    break;
//                }
//            }
//        }
//
//    }
//    static void MapMoves (ArrayList<MapLocation> maps, Player Player, int addX, int addY) {
//        for (int i = 0; i < maps.size(); i++) {
//            JLabel map = maps.get(i);
//            int MAP_X = map.getX();
//            int MAP_Y = map.getY();
//            map.setLocation(MAP_X + addX , MAP_Y + addY);
//
//
//        }
//
//        for (int a = 0; a < Combo_General.list_players.size(); a++){
//            if (!(Combo_General.list_players.get(a).unique_code).equals("I")){
//                int x = Combo_General.list_players.get(a).getX();
//                int y = Combo_General.list_players.get(a).getY();
//                x = x + addX;
//                y = y + addY;
//                Combo_General.list_players.get(a).setLocation(x, y);
//            }
//        }
//    }
//
//    static void move_other_players(Player playerik, int x, int y, int mapX, int mapY){
//        System.out.println("MAP_OTH  " + mapX+  "  " + mapY);
//        int IMapX = Combo_General.maps.get(0).getX();
//        int IMapY = Combo_General.maps.get(0).getY();
//        System.out.println("IMAP   " + IMapX + "  " + IMapY);
//        int mapX_dob = -IMapX+mapX;
//        int mapY_dob = -IMapY+mapY;
//        System.out.println("MAPDOB  " + mapX_dob + "  "+ + mapY_dob);
//
//        x = x - mapX_dob;
//        y = y - mapY_dob;
//        System.out.println("XY  "+  x+ "  " + +y);
//        playerik.setLocation(x, y);
//    }
//
//    static Timer timer (ArrayList<MapLocation> maps, Player Player, String direction) {
//
//        Timer timer = new Timer(30, null);
//        timer.addActionListener(new ActionListener() {
//            int addx = 0;
//            int addy = 0;
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int addX = 0;
//                int addY = 0;
//                blockNow = false;
//                if (direction.equals("right")) {
//                    addX = - Player.velocity;
//                    blockRight = blockNow;
//                    addx = -20;
//                }
//                else if (direction.equals("left")) {
//                    addX =  Player.velocity;
//                    blockLeft = blockNow;
//                    addx = 20;
//                }
//                else if (direction.equals("forward")) {
//                    addY = Player.velocity;
//                    blockUp = blockNow;
//                    addy = 20;
//                }
//                else if (direction.equals("toward")) {
//                    addY = - Player.velocity;
//                    blockDown = blockNow;
//                    addy = -20;
//                }
//
//                shouldMapMove(Player, direction);
//                palkaFor(maps, Player, addx,addy, timer);
//
//
//                if(shouldMoveMaps) {
//                    MapMoves(maps, Player, addX, addY);
//                }
//
//                pickUpArtefacts(Player, maps);
//            }
//        });
//        return timer;
//    }
//
//
//    static void pickUpArtefacts(Player Player, ArrayList<MapLocation> maps) {
//        // собираем артефакты
//
//        for (int i = 0; i < maps.size(); i++) {
//            MapLocation map = maps.get(i);
//            for (int j = 0; j < map.artefacts.size(); j++) {
//                Artefact artefact = map.artefacts.get(j);
//                if (ArtefactContloller.isIntersected(Player, artefact, map)) {
//                    map.remove(artefact);
//                }
//            }
//        }
//    }
//
//
//}
