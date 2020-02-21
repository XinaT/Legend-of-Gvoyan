package ru.compas;

import ru.compas.character;
import ru.compas.player;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class controller {
    String direction = " ";


    controller(JFrame frame, player player,JLabel label) {
        int x = player.getX();
        int y =player.getY();
        int x2 = label.getX();
        int y2 =label.getY();
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (y > 250 && e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                    player.move("forward");
                    label.setLocation(x,y - 10);
                }
                if (y < 750 && e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                    player.move("toward");
                    label.setLocation(x,y + 10);
                }
                if (x > 250 && e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
                    player.move("left");
                    label.setLocation(x - 10,y);
                }
                if ( x < 750 && e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                    player.move("right");
                    label.setLocation(x + 10,y);
                }


                if (y <= 250 && e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                    player.move("forward");
                    label.setLocation(x2,y2 + 10);
                }
                if (y >= 750 && e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                    player.move("toward");
                    label.setLocation(x2,y2 - 10);
                }
                if (x <= 250 && e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
                    player.move("left");
                    label.setLocation(x2 + 10,y2);
                }
                if ( x >= 750 && e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                    player.move("right");
                    label.setLocation(x2 - 10,y2);
                }
            }
        });

    }
}
