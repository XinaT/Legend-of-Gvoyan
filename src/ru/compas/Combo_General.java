package ru.compas;

import ru.compas.backpack.Backpack;
import ru.compas.collision.CollisionKarta;
import ru.compas.collision.Palka;
import ru.compas.collision.Point;
import ru.compas.objects.Domik;
import ru.compas.objects.DomikController;
import ru.compas.things.Artefact;
import ru.compas.things.ArtefactContloller;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;



public class Combo_General {

    public static JLayeredPane pane = null;
    public static ArrayList<Player> list_players = null;
    public static ArrayList<MapLocation> maps = null;
    public static boolean isServer = false;

    static Backpack backpack;
    public static boolean R = false;


    public static Player player_make(ImageIcon icon, int x, int y, String name){
        Player player = new Player();
        player.setSize(70,70);
        player.setIcon(icon);
        player.setLocation(x, y);
        player.unique_code = name;
        pane.add(player);
        pane.setLayer(player, 5);
        return player;
    }


    public static JFrame creatOkno() {
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    if(backpack == null) {
                        backpack = new Backpack(frame.getWidth() / 2, frame.getHeight(), new ArrayList<>());
                    }
                    if(!R) {
                        backpack.setVisible(true);
                        R = true;
                    }
                }
            }
        });
        return frame;
    }



        public static JLayeredPane pane_made(JFrame frame){
        JLayeredPane pane = new JLayeredPane();
        pane.setSize(frame.getWidth(), frame.getHeight());
        pane.setLocation(0, 0);
        frame.add(pane);
        return pane;
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

        ArrayList<Domik> domiks = DomikController.createDomik();
        for (int i = 0; i < domiks.size(); i++) {
            Domik domik = domiks.get(i);
            map.add(domik);
            map.collisionObjects.add(domik);
        }

        return map;

    }

}
