package ru.compas;

import ru.compas.collision.CollisionKarta;
import ru.compas.collision.CollisionUtils;
import ru.compas.collision.Palka;
import ru.compas.collision.Point;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        frame.setLayout(null);

        player player = new player();
        player.setSize(100,100);
        player.setIcon(new ImageIcon("pers.png"));
        player.setLocation(100,100);
        frame.add(player);



//        JLabel map = new JLabel();
//        map.setSize(frame.getWidth(),frame.getHeight());
//        map.setIcon(new ImageIcon("нижняя часть карты.jpg"));
//        map.setOpaque(true);
//        map.setLocation(0,0);
//        frame.add(map);


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
        controller controller = new controller(frame,player,karta,palki);



        frame.setVisible(true);
    }
}
