package ru.compas;

import ru.compas.collision.CollisionKarta;
import ru.compas.collision.Palka;
import ru.compas.collision.Point;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        JFrame frame = creatOkno();

        player player = player(frame);
        MapLocation SmallMap = createSmallMap(-667, 280, frame);
        MapLocation map = creatMap(-2000, -2000, ("Правая нижняя часть карты 2.png"), frame);


        ArrayList<MapLocation> maps = new ArrayList<>();
        maps.add(map);


        maps.add(SmallMap);

        controller controller = new controller(frame, player, maps);

        frame.setVisible(true);
    }

    public static JFrame creatOkno() {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setLayout(null);
        return frame;
    }

    public static player player(JFrame frame) {
        player player = new player();
        player.setSize(70, 70);
        player.setIcon(new ImageIcon("pers.png"));
        player.setLocation(300, 300);
        frame.add(player);
        return player;
    }

    public static MapLocation createSmallMap(int x , int y, JFrame frame) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(100, 0));
        points.add(new Point(100, 100));
        points.add(new Point(0, 100));
        points.add(new Point(0, 0));

        ArrayList<Palka> palki = new ArrayList<>();

        for (int i = 0; i < points.size() - 1; i++) {
            Point a = points.get(i);
            Point b = points.get(i + 1);
            Palka palka = new Palka(a, b);
            palki.add(palka);
        }

        CollisionKarta karta = new CollisionKarta(palki);
        karta.setSize(100, 100);


        MapLocation map = new MapLocation(karta);
        map.setSize(120, 120);
        map.setOpaque(true);
        map.setLocation(x, y);
        frame.add(map);

        return map;
    }

    public static MapLocation creatMap(int x, int y, String icon, JFrame frame) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(549, 0));

        points.add(new Point(549, 125));
        points.add(new Point(622, 125));
        points.add(new Point(622, 503));
        points.add(new Point(440, 503));
        points.add(new Point(440, 605));
        points.add(new Point(404, 605));
        points.add(new Point(404, 917));
        points.add(new Point(659, 917));
        points.add(new Point(659, 1054));
        points.add(new Point(769, 1054));
        points.add(new Point(769, 1261));
        points.add(new Point(1683, 1261));
        points.add(new Point(1683, 1123));
        points.add(new Point(2119, 1123));
        points.add(new Point(2119, 1467));
        points.add(new Point(2484, 1467));
        points.add(new Point(2484, 1535));
        points.add(new Point(2556, 1535));
        points.add(new Point(2556, 1948));
        points.add(new Point(2483, 1948));
        points.add(new Point(2483, 2498));
        points.add(new Point(2013, 2498));
        points.add(new Point(2013, 2429));
        points.add(new Point(1609, 2429));
        points.add(new Point(1609, 2396));
        points.add(new Point(1208, 2396));
        points.add(new Point(1208, 2533));
        points.add(new Point(988, 2533));
        points.add(new Point(988, 2395));
        points.add(new Point(768, 2395));
        points.add(new Point(768, 2189));
        points.add(new Point(441, 2189));
        points.add(new Point(441, 1984));
        points.add(new Point(513, 1984));
        points.add(new Point(513, 1742));
        points.add(new Point(443, 1742));
        points.add(new Point(443, 1536));
        points.add(new Point(549, 1536));
        points.add(new Point(549, 1124));
        points.add(new Point(221, 1124));
        points.add(new Point(221, 985));
        points.add(new Point(76, 985));
        points.add(new Point(76, 606));

//        points.add(new Point(1329, 2392 - 500));
//        points.add(new Point(1461, 2392 - 500));
//        points.add(new Point(1461, 2271 - 500));
//        points.add(new Point(1329, 2271 - 500));


        // чтоб палки совпадали с картой
        for (int i = 0; i < points.size(); i = i + 1) {
            Point p = points.get(i);
            p.y = p.y + 496;
        }


        ArrayList<Palka> palki = new ArrayList<>();

        for (int i = 0; i < points.size() - 1; i++) {
            Point a = points.get(i);
            Point b = points.get(i + 1);
            Palka palka = new Palka(a, b);
            palki.add(palka);
        }

        JLabel Domik = new JLabel();
        Domik.setLocation(1293, 2210);
        Domik.setSize(250, 250);
        Domik.setVisible(true);
        Domik.setOpaque(false);
        Domik.setIcon(new ImageIcon("Домик.png"));

        CollisionKarta karta = new CollisionKarta(palki);
        karta.setSize(3000, 4000);

        MapLocation map = new MapLocation(karta);
        map.setSize(3000, 4000);
        map.setIcon(new ImageIcon(icon));
        map.setOpaque(true);
        map.setLocation(x, y);
        frame.add(map);
        map.add(Domik);
        map.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println(e.getX() + " " + e.getY());
            }
        });


        return map;


    }
}
