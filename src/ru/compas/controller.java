package ru.compas;

import ru.compas.character;
import ru.compas.collision.CollisionUtils;
import ru.compas.collision.Palka;
import ru.compas.player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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



    controller(JFrame frame, player player, ArrayList<MapLocation> maps) {

        RIGHT_BORDER = frame.getWidth() - 250;
        BOTTOM_BORDER = frame.getHeight() - 250;

        Timer up = new Timer(40, null);
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 blockDown = false;
                 blockRight = false;
                 blockLeft = false;


                shouldMoveMaps = false;
                int x = player.getX();
                int y = player.getY();
                if (y > TOP_BORDER) {
                    player.move("forward");
                } else if (y <= TOP_BORDER) {
                    shouldMoveMaps = true;
                }

                for (int i = 0; i < maps.size(); i++) {
                    MapLocation map = maps.get(i);
                    for (int j = 0; j < map.karta.palki.size(); j++) {
                        Palka palka = map.karta.palki.get(j);
                        if (CollisionUtils.isPersAndPalkaIntersected(player, palka, map)) {
                            player.move("stop");
                            player.setLocation(x, y+20);
                            blockUp = true;
                            shouldMoveMaps = false;
                            up.stop();
                            break;
                        }
                    }
                }

                if (shouldMoveMaps) {
                    for (int i = 0; i < maps.size(); i++) {
                        JLabel map = maps.get(i);
                        int MAP_X = map.getX();
                        int MAP_Y = map.getY();

                        map.setLocation(MAP_X, MAP_Y + player.velocity);
                    }
                }
            }
        });

        Timer left = new Timer(30, null);
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blockUp = false;
                blockDown = false;
                blockRight = false;


                shouldMoveMaps = false;
                int x = player.getX();
                int y = player.getY();
                if (x > LEFT_BORDER) {
                    player.move("left");
                } else if (x <= LEFT_BORDER) {
                    shouldMoveMaps = true;
                }

                for (int i = 0; i < maps.size(); i++) {
                    MapLocation map = maps.get(i);
                    for (int j = 0; j < map.karta.palki.size(); j++) {
                        Palka palka = map.karta.palki.get(j);
                        if (CollisionUtils.isPersAndPalkaIntersected(player, palka, map)) {
                            player.move("stop");
                            player.setLocation(x+20, y);
                            shouldMoveMaps = false;
                            blockLeft = true;
                            left.stop();
                            break;
                        }
                    }
                }

                if (shouldMoveMaps) {
                    for (int i = 0; i < maps.size(); i++) {
                        JLabel map = maps.get(i);
                        int MAP_X = map.getX();
                        int MAP_Y = map.getY();
                        map.setLocation(MAP_X + player.velocity, MAP_Y);

                    }
                }
            }
        });

        Timer right = new Timer(40, null);
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blockDown = false;
                blockLeft = false;
                blockUp=false;

//
//
                shouldMoveMaps = false;

                int x = player.getX();
                int y = player.getY();
                if (x < RIGHT_BORDER) {
                    player.move("right");
                } else if (x >= RIGHT_BORDER) {
                    shouldMoveMaps = true;

                }

                for (int i = 0; i < maps.size(); i++) {
                    MapLocation map = maps.get(i);
                    for (int j = 0; j < map.karta.palki.size(); j++) {
                        Palka palka = map.karta.palki.get(j);
                        if (CollisionUtils.isPersAndPalkaIntersected(player, palka, map)) {
                            player.move("stop");
                            player.setLocation(x-20, y);
                            shouldMoveMaps = false;
                            blockRight =true;
                            right.stop();
                            break;
                        }
                    }
                }

                if(shouldMoveMaps){
                    for (int i = 0; i < maps.size(); i++) {
                        JLabel map = maps.get(i);
                        int MAP_X = map.getX();
                        int MAP_Y = map.getY();
                        map.setLocation(MAP_X - player.velocity, MAP_Y);
                    }
                }
            }
        });

        Timer down = new Timer(40, null);
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blockUp = false;
                blockRight = false;
                blockLeft = false;

                shouldMoveMaps = false;
                int x = player.getX();
                int y = player.getY();
                if (y < BOTTOM_BORDER) {
                    player.move("toward");
                } else if (y >= BOTTOM_BORDER) {
                    shouldMoveMaps = true;

                }

                for (int i = 0; i < maps.size(); i++) {
                    MapLocation map = maps.get(i);
                    for (int j = 0; j < map.karta.palki.size(); j++) {
                        Palka palka = map.karta.palki.get(j);
                        if (CollisionUtils.isPersAndPalkaIntersected(player, palka, map)) {
                            player.move("stop");
                            player.setLocation(x, y-20);
                            shouldMoveMaps = false;
                            blockDown = true;
                            down.stop();
                            break;
                        }
                    }
                }
                if (shouldMoveMaps){
                    for (int i = 0; i < maps.size(); i++) {
                        JLabel map = maps.get(i);
                        int MAP_X = map.getX();
                        int MAP_Y = map.getY();
                        map.setLocation(MAP_X, MAP_Y - player.velocity);
                    }
                }

            }
        });

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

        });

        frame.addKeyListener(new KeyAdapter() {
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
}
