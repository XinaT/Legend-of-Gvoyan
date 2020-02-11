package ru.compas.draft;

import ru.compas.character;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        character chel = new character();
//        chel.setBackground(Color.blue);
        chel.setOpaque(true);
        chel.setSize(100, 100);
        chel.setIcon(new ImageIcon("pers.png"));
        chel.setLocation(100, 100);
        frame.add(chel);

        frame.setVisible(true);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    chel.move("forward");
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    chel.move("toward");
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    chel.move("left");
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    chel.move("right");
                }
            }
        });
    }
}
