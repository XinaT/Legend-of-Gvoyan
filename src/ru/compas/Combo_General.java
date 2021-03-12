package ru.compas;

import ru.compas.Messager.Message;
import ru.compas.collision.CollisionKarta;
import ru.compas.collision.Palka;
import ru.compas.collision.Point;
import ru.compas.things.Artefact;
import ru.compas.things.ArtefactContloller;

import javax.swing.*;
import java.util.ArrayList;



public class Combo_General {

    public static JLayeredPane pane = null;

    public static ArrayList<Message> createmes(){
        ArrayList<Message> messages = new ArrayList<>();
        Message message1 = new Message("Arab",new ImageIcon("Охотник.png"),true);
        messages.add(message1);

        Message message2 = new Message("Kavkazec",new ImageIcon("Болотный Лягуш.png"),true);
        messages.add(message2);

        Message message3 = new Message("Aaaooaa",new ImageIcon("Дух цветов.png"),true);
        messages.add(message3);

        Message message4 = new Message("Armen",new ImageIcon("Древесный киборг.png"),true);
        messages.add(message4);
        return messages;
    }

    public static player player_make(ImageIcon icon, int x, int y, String name){
        player player = new player();
        player.setSize(70,70);
        player.setIcon(icon);
        player.setLocation(x, y);
        player.unique_code = name;
        pane.add(player);
        pane.setLayer(player, 3);
        return player;
    }

//    public static MapLocation creatMap(int x,int y, String icon, JFrame frame){
//        ArrayList<Point> points = new ArrayList<>();
//        points.add(new Point(549,0));
//
//        points.add(new Point(549,125));
//        points.add(new Point(622,125));
//        points.add(new Point(622,503));
//        points.add(new Point(440,503));
//        points.add(new Point(440,605));
//        points.add(new Point(404,605));
//        points.add(new Point(404,917));
//        points.add(new Point(659,917));
//        points.add(new Point(659,1054));
//        points.add(new Point(769,1054));
//        points.add(new Point(769,1261));
//        points.add(new Point(1683,1261));
//        points.add(new Point(1683,1123));
//        points.add(new Point(2119,1123));
//        points.add(new Point(2119,1467));
//        points.add(new Point(2484,1467));
//        points.add(new Point(2484,1535));
//        points.add(new Point(2556,1535));
//        points.add(new Point(2556,1948));
//        points.add(new Point(2483,1948));
//        points.add(new Point(2483,2498));
//        points.add(new Point(2013,2498));
//        points.add(new Point(2013,2429));
//        points.add(new Point(1609,2429));
//        points.add(new Point(1609,2396));
//        points.add(new Point(1208,2396));
//        points.add(new Point(1208,2533));
//        points.add(new Point(988,2533));
//        points.add(new Point(988,2395));
//        points.add(new Point(768,2395));
//        points.add(new Point(768,2189));
//        points.add(new Point(441,2189));
//        points.add(new Point(441,1984));
//        points.add(new Point(513,1984));
//        points.add(new Point(513,1742));
//        points.add(new Point(443,1742));
//        points.add(new Point(443,1536));
//        points.add(new Point(549,1536));
//        points.add(new Point(549,1124));
//        points.add(new Point(221,1124));
//        points.add(new Point(221,985));
//        points.add(new Point(76,985));
//        points.add(new Point(76,606));
//
//
//
//
//        // чтоб палки совпадали с картой
//        for (int i = 0; i < points.size(); i = i + 1) {
//            Point p = points.get(i);
//            p.y = p.y + 500;
//        }
//
//
//
//
//        ArrayList<Palka> palki = new ArrayList<>();
//
//        for (int i = 0; i < points.size() - 1; i++) {
//            Point a = points.get(i);
//            Point b = points.get(i + 1);
//            Palka palka = new Palka(a, b);
//            palki.add(palka);
//        }
//
//        CollisionKarta karta = new CollisionKarta(palki);
//        karta.setSize(3000,4000);
//
//        MapLocation map = new MapLocation(karta, );
//        map.setSize(3000, 4000);
//        map.setIcon(new ImageIcon(icon));
//        map.setOpaque(true);
//        map.setLocation(x,y);
//        Combo_General.pane.add(map);
//        Combo_General.pane.setLayer(map, 1);
//        frame.repaint();
//        return map;
//
//    }

//    public static MapLocation mapWithoutPalkiCreate(int x, int y, JFrame frame, String icon){
//        ArrayList<Palka> palkaNullList = new ArrayList<>();
//        CollisionKarta karta = new CollisionKarta(palkaNullList);
//        karta.setSize(3000,4000);
//
//        MapLocation map = new MapLocation(karta);
//        map.setSize(3000, 4000);
//        map.setIcon(new ImageIcon(icon));
//        map.setOpaque(true);
//        map.setLocation(x,y);
//        Combo_General.pane.add(map);
//        Combo_General.pane.setLayer(map, 1);
//        return map;
//    }
//
    public static JFrame creatOkno(){
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        return frame;
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


        ArrayList<Artefact> all = new ArrayList<>();
        ArrayList<Artefact> coins = ArtefactContloller.createCoins();
        ArrayList<Artefact> swords = ArtefactContloller.createSwords();
        ArrayList<Artefact> bows = ArtefactContloller.createBows();

        all.addAll(coins);
        all.addAll(swords);
        all.addAll(bows);

        MapLocation map = new MapLocation(karta, all);
        map.setSize(3000, 4000);
        map.setIcon(new ImageIcon(icon));
        map.setOpaque(true);
        map.setLocation(x,y);
        frame.add(map);

        for (int i = 0; i < all.size(); i++) {
            Artefact artefact = all.get(i);
            map.add(artefact);
        }
        return map;

    }


}
