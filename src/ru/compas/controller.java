package ru.compas;

import ru.compas.collision.CollisionUtils;
import ru.compas.collision.Palka;
import ru.compas.things.Coin;
import ru.compas.things.CoinController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

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

    controller(JFrame frame, player player, ArrayList<MapLocation> maps) {

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
        }
        else {
            shouldMoveMaps = true;
        }

    }

        static void palkaFor (ArrayList<MapLocation> maps, player player, int addx, int addy, Timer timer) {
        int x =player.getX();
        int y =player.getY();
        for (int i = 0; i < maps.size(); i++) {
            MapLocation map = maps.get(i);
            for (int j = 0; j < map.karta.palki.size(); j++) {
                Palka palka = map.karta.palki.get(j);
                if (CollisionUtils.isPersAndPalkaIntersected(player, palka, map)) {
                    player.move("stop");
                    player.setLocation(x + addx,y + addy);
                    shouldMoveMaps = false;
                    blockNow = true;
                    timer.stop();
                    break;
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
                    addX = - player.velocity;
                    blockRight = blockNow;
                    addx = -20;
                }
                else if (direction.equals("left")) {
                    addX =  player.velocity;
                    blockLeft = blockNow;
                    addx = 20;
                }
                else if (direction.equals("forward")) {
                    addY = player.velocity;
                    blockUp = blockNow;
                    addy = 20;
                }
                else if (direction.equals("toward")) {
                    addY = - player.velocity;
                    blockDown = blockNow;
                    addy = -20;
                }

                shouldMapMove(player, direction);
                palkaFor(maps, player, addx,addy, timer);

                if(shouldMoveMaps) {
                    MapMoves(maps, player, addX, addY);
                }

                pickUpArtefacts(player, maps);
            }
        });
        return timer;
    }


    static void pickUpArtefacts(player player, ArrayList<MapLocation> maps) {
        // собираем артефакты

        for (int i = 0; i < maps.size(); i++) {
            MapLocation map = maps.get(i);
            for (int j = 0; j < map.coins.size(); j++) {
                Coin coin = map.coins.get(j);
                if (CoinController.isIntersected(player, coin, map)) {
                    map.remove(coin);
                }
            }
        }
    }


}
