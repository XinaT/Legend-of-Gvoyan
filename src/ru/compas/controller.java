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
                    up.start();
                } else if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)) {
                    down.start();
                } else if ((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)) {
                    left.start();
                } else if ((e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)) {
                    right.start();
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

        static void palkaFor (ArrayList<MapLocation> maps, player player) {
        for (int i = 0; i < maps.size(); i++) {
            MapLocation map = maps.get(i);
            for (int j = 0; j < map.karta.palki.size(); j++) {
                Palka palka = map.karta.palki.get(j);
                if (CollisionUtils.isPersAndPalkaIntersected(player, palka, map)) {
                    player.setLocation(player.getX(), player.getY());
                    shouldMoveMaps = false;
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
            @Override
            public void actionPerformed(ActionEvent e) {
                shouldMapMove(player, direction);
                palkaFor(maps, player);
                if(shouldMoveMaps){
                    int addX = 0;
                    int addY = 0;

                      if (direction.equals("right")) {
                       addX = - player.velocity;
                      }
                      else if (direction.equals("left")) {
                       addX =  player.velocity;
                      }
                      else if (direction.equals("forward")) {
                       addY = player.velocity;
                      }
                      else if (direction.equals("toward")) {
                       addY = - player.velocity;
                      }

                    MapMoves(maps, player, addX, addY);
                }
            }
        });
        return timer;
    }


}
