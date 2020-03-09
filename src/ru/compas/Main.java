package ru.compas;

import ru.compas.collision.CollisionKarta;
import ru.compas.collision.CollisionUtils;
import ru.compas.collision.Palka;
import ru.compas.collision.Point;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        JFrame frame = creatOkno();

        player player = player(frame);

        MapLocation map = creatMap(0,0,("нижняя часть карты.jpg"),frame);

        MapLocation map2 = creatMap(0,1000,("images-1.jpeg"),frame);

        MapLocation map3 = creatMap(1000,1000,("images-2.jpeg"),frame);

        MapLocation map4 = creatMap(1000,0,("images-3.jpeg"),frame);

        MapLocation map5 = creatMap(-1000,-1000,("images-4.jpeg"),frame);

        MapLocation map6 = creatMap(0,-1000,("images-5.jpeg"),frame);

        MapLocation map7 = creatMap(-1000,0,("images-6.jpeg"),frame);

        MapLocation map8 = creatMap(-1000,1000,("images-7.jpeg"),frame);

        MapLocation map9 = creatMap(1000,-1000,("libertycityL.jpg"),frame);


        ArrayList<MapLocation> maps = new ArrayList<>();
        maps.add(map);
        maps.add(map2);
        maps.add(map3);
        maps.add(map4);
        maps.add(map5);
        maps.add(map6);
        maps.add(map7);
        maps.add(map8);
        maps.add(map9);

        controller controller = new controller(frame,player,maps);

        frame.setVisible(true);
    }
    public static JFrame creatOkno(){
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        return frame;
    }

    public static player player(JFrame frame){
        player player = new player();
        player.setSize(100,100);
        player.setIcon(new ImageIcon("pers.png"));
        player.setLocation(500,500);
        frame.add(player);
        return player;
    }

    public static MapLocation creatMap(int x,int y, String icon, JFrame frame){
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
        karta.setSize(1000,1000);

        MapLocation map = new MapLocation(karta);
        map.setSize(frame.getWidth(),frame.getHeight());
        map.setIcon(new ImageIcon(icon));
        map.setOpaque(true);
        map.setLocation(x,y);
        frame.add(map);
        return map;

    }
}
