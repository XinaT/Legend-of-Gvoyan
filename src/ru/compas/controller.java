package ru.compas;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class controller {

    controller(JFrame frame, player player, ArrayList<JLabel> maps) {

        Timer up = new Timer(30,null);
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = player.getX();
                int y = player.getY();
                if (y > 250){
                    player.move("forward");
                }else if (y <= 250){
                    for (int i = 0; i < maps.size(); i++) {
                        JLabel map = maps.get(i);
                        int x2 = map.getX();
                        int y2 = map.getY();
                        map.setLocation(x2, y2 + 10);
                    }
                }

            }
        });

        Timer left = new Timer(30,null);
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = player.getX();
                int y = player.getY();
                if (x > 250){
                    player.move("left");
                }else if (x <= 250){
                    for (int i = 0; i < maps.size(); i++) {
                        JLabel map = maps.get(i);
                        int x2 = map.getX();
                        int y2 = map.getY();
                        map.setLocation(x2, y2 + 10);
                        map.setLocation(x2 + 10, y2);
                    }
                }
            }
        });

        Timer right = new Timer(30,null);
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = player.getX();
                int y = player.getY();
                if (x < 750){
                    player.move("right");
                }else if (x >= 750){
                    for (int i = 0; i < maps.size(); i++) {
                        JLabel map = maps.get(i);
                        int x2 = map.getX();
                        int y2 = map.getY();
                        map.setLocation(x2, y2 + 10);
                        map.setLocation(x2 - 10, y2);
                    }
                }
            }
        });

        Timer down = new Timer(30,null);
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = player.getX();
                int y = player.getY();
                if (y < 750){
                    player.move("toward");
                }else if (y >= 750){
                    for (int i = 0; i < maps.size(); i++) {
                        JLabel map = maps.get(i);
                        int x2 = map.getX();
                        int y2 = map.getY();
                        map.setLocation(x2, y2 + 10);
                        map.setLocation(x2, y2 - 10);
                    }
                }
            }
        });

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if ((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)){
                    up.start();
                } else if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)){
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

                if ((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)){
                      player.move("forward");
                    up.stop();
                } else if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)){
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
