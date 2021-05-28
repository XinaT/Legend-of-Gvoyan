package ru.compas.objects;

import ru.compas.collision.CollisionKarta;
import ru.compas.collision.CollisionObject;
import ru.compas.collision.Palka;
import ru.compas.collision.Point;

import javax.swing.*;
import java.util.ArrayList;

public class Gate extends CollisionObject {
    public Gate (int x,int y){
        super(x,y, 230, 200);
        setLocation(x, y);
        setSize(230,200);
        setVisible(true);
        setOpaque(false);
        setIcon(new ImageIcon("vorota.png"));

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(550,1774));
        points.add(new Point(773,1771));




        ArrayList<Palka> palki = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            Point a = points.get(i);
            Point b = points.get(i + 1);
            Palka palka = new Palka(a, b);
            palka.type = "gate";
            palki.add(palka);
        }

        karta = new CollisionKarta(palki);

    }
}
