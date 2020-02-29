package ru.compas.collision;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setLayout(null);

        JLabel pers = new JLabel();
        pers.setLocation(100, 101);
        pers.setSize(100, 100);
        pers.setOpaque(true);
        pers.setBackground(Color.BLACK);
        frame.add(pers);

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(100, 100));
        points.add(new Point(500, 100));
        points.add(new Point(700, 300));
        points.add(new Point(700, 600));
        points.add(new Point(500, 700));
        points.add(new Point(100, 700));

        ArrayList<Palka> palki = new ArrayList<>();

        for (int i = 0; i < points.size() - 1; i++) {
            Point a = points.get(i);
            Point b = points.get(i + 1);
            Palka palka = new Palka(a, b);
            palki.add(palka);
        }

        CollisionKarta karta = new CollisionKarta(palki);
        karta.setLocation(0, 0);
        karta.setSize(frame.getWidth(), frame.getHeight());
        frame.add(karta);


        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int x = pers.getX();
                int y = pers.getY();

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    pers.setLocation(x - 5, y);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    pers.setLocation(x, y + 5);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    pers.setLocation(x + 5, y);
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    pers.setLocation(x, y - 5);
                }

                for (int i = 0; i < palki.size(); i++) {
                    Palka palka = palki.get(i);
                    if (CollisionUtils.isPersAndPalkaIntersected(pers, palka)) {
                        pers.setLocation(x, y);
                        break;
                    }
                }
            }
        });

        frame.setVisible(true);
    }
}
