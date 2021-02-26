package ru.compas;

import ru.compas.things.Coin;
import ru.compas.Messager.Dialog;
import ru.compas.Messager.Message;
import ru.compas.collision.CollisionKarta;
import ru.compas.collision.Palka;
import ru.compas.collision.Point;
import ru.compas.things.CoinController;

import javax.swing.*;
import java.util.ArrayList;

public class Main_GENERAL {
    public static void main(String[] args) {

        JFrame frame = creatOkno();

        player player = player(frame);

        Dialog dialog = new Dialog(Main_GENERAL.createmes(), frame);
        frame.add(dialog);

        MapLocation map = creatMap(-2000,-2000,("Правая нижняя часть карты 2.png"),frame);

        MapLocation map1 = mapWithoutPalkiCreate(-5000, -2000, frame,  ("Карта_01.jpg"));
        MapLocation map2 = mapWithoutPalkiCreate(-5000, -6000, frame, ("Карта_02.jpg"));
        MapLocation map3 = mapWithoutPalkiCreate(-2000, -6000, frame, ("Карта_03.jpg"));


        ArrayList<MapLocation> maps = new ArrayList<>();
        maps.add(map);
        maps.add(map1);
        maps.add(map2);
        maps.add(map3);

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
        player.setSize(70,70);
        player.setIcon(new ImageIcon("pers.png"));
        player.setLocation(300,300);
        frame.add(player);
        return player;
    }

    public static MapLocation creatMap(int x,int y, String icon, JFrame frame){
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(549,0));

        points.add(new Point(549,125));
        points.add(new Point(622,125));
        points.add(new Point(622,503));
        points.add(new Point(440,503));
        points.add(new Point(440,605));
        points.add(new Point(404,605));
        points.add(new Point(404,917));
        points.add(new Point(659,917));
        points.add(new Point(659,1054));
        points.add(new Point(769,1054));
        points.add(new Point(769,1261));
        points.add(new Point(1683,1261));
        points.add(new Point(1683,1123));
        points.add(new Point(2119,1123));
        points.add(new Point(2119,1467));
        points.add(new Point(2484,1467));
        points.add(new Point(2484,1535));
        points.add(new Point(2556,1535));
        points.add(new Point(2556,1948));
        points.add(new Point(2483,1948));
        points.add(new Point(2483,2498));
        points.add(new Point(2013,2498));
        points.add(new Point(2013,2429));
        points.add(new Point(1609,2429));
        points.add(new Point(1609,2396));
        points.add(new Point(1208,2396));
        points.add(new Point(1208,2533));
        points.add(new Point(988,2533));
        points.add(new Point(988,2395));
        points.add(new Point(768,2395));
        points.add(new Point(768,2189));
        points.add(new Point(441,2189));
        points.add(new Point(441,1984));
        points.add(new Point(513,1984));
        points.add(new Point(513,1742));
        points.add(new Point(443,1742));
        points.add(new Point(443,1536));
        points.add(new Point(549,1536));
        points.add(new Point(549,1124));
        points.add(new Point(221,1124));
        points.add(new Point(221,985));
        points.add(new Point(76,985));
        points.add(new Point(76,606));




        // чтоб палки совпадали с картой
        for (int i = 0; i < points.size(); i = i + 1) {
            Point p = points.get(i);
            p.y = p.y + 500;
        }




        ArrayList<Palka> palki = new ArrayList<>();

        for (int i = 0; i < points.size() - 1; i++) {
            Point a = points.get(i);
            Point b = points.get(i + 1);
            Palka palka = new Palka(a, b);
            palki.add(palka);
        }

        CollisionKarta karta = new CollisionKarta(palki);
        karta.setSize(3000,4000);

        ArrayList<Coin> coins = CoinController.createCoins();

        MapLocation map = new MapLocation(karta, coins);
        map.setSize(3000, 4000);
        map.setIcon(new ImageIcon(icon));
        map.setOpaque(true);
        map.setLocation(x,y);
        frame.add(map);

        for (int i = 0; i < coins.size(); i++) {
            Coin coin = coins.get(i);
            map.add(coin);
        }
        return map;

    }

    public static MapLocation mapWithoutPalkiCreate(int x, int y, JFrame frame, String icon){
        ArrayList<Palka> palkaNullList = new ArrayList<>();
        CollisionKarta karta = new CollisionKarta(palkaNullList);
        karta.setSize(3000,4000);

        MapLocation map = new MapLocation(karta);
        map.setSize(3000, 4000);
        map.setIcon(new ImageIcon(icon));
        map.setOpaque(true);
        map.setLocation(x,y);
        frame.add(map);
        return map;
    }
}
