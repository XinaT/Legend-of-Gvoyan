package ru.compas.draft;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ne_dvigaticya_v_vverh {
    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        frame.setLayout(null);

        JButton button = new JButton();
        button.setSize(100,100);
        button.setLocation(450,450);
        button.setFocusable(false);
        frame.add(button);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int x =button.getX();
                int y =button.getY();

                if (e.getKeyCode() == KeyEvent.VK_A) {
                    button.setLocation(x - 10,y);
                }else if (e.getKeyCode() == KeyEvent.VK_D) {
                    button.setLocation(x + 10,y);
                }else if (e.getKeyCode() == KeyEvent.VK_S) {
                    button.setLocation(x,y + 10);
                }else if (e.getKeyCode() == KeyEvent.VK_W) {
                    button.setLocation(x, y - 10);
                }

                if (isIntersected(button.getX(),button.getY())){
                    button.setLocation(x, y);
                }
            }
        });



        frame.setVisible(true);
    }

    public static boolean isIntersected(int x, int y) {
        if (x <= 0) {
            return true;
        } else if (y <= 0) {
            return true;
        } else {
            return false;
        }
    }
}


