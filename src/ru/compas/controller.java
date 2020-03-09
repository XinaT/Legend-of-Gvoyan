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



    controller(JFrame frame, player player, ArrayList<MapLocation> maps) {

        Timer up = new Timer(30, null);
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean shouldMoveMaps = false;
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
                            player.setLocation(x, y);
                            shouldMoveMaps = false;
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
                int x = player.getX();
                int y = player.getY();
                if (x > LEFT_BORDER) {
                    player.move("left");
                } else if (x <= LEFT_BORDER) {
                    for (int i = 0; i < maps.size(); i++) {
                        JLabel map = maps.get(i);
                        int MAP_X = map.getX();
                        int MAP_Y = map.getY();
                        map.setLocation(MAP_X + player.velocity, MAP_Y);
                    }
                }
            }
        });

        Timer right = new Timer(30, null);
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = player.getX();
                int y = player.getY();
                if (x < RIGHT_BORDER) {
                    player.move("right");
                } else if (x >= RIGHT_BORDER) {
                    for (int i = 0; i < maps.size(); i++) {
                        JLabel map = maps.get(i);
                        int MAP_X = map.getX();
                        int MAP_Y = map.getY();
                        map.setLocation(MAP_X - player.velocity, MAP_Y);
                    }
                }
            }
        });

        Timer down = new Timer(30, null);
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = player.getX();
                int y = player.getY();
                if (y < BOTTOM_BORDER) {
                    player.move("toward");
                } else if (y >= BOTTOM_BORDER) {
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
                    up.start();
                } else if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)) {
                    down.start();
                } else if ((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)) {
                    left.start();
                } else if ((e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)) {
                    right.start();
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
