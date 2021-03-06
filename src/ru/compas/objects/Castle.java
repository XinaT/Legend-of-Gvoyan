package ru.compas.objects;

import ru.compas.collision.CollisionKarta;
import ru.compas.collision.CollisionObject;
import ru.compas.collision.Palka;
import ru.compas.collision.Point;

import javax.swing.*;
import java.util.ArrayList;

public class Castle extends CollisionObject {
    public Castle(int x, int y) {
        super(x,y, 700, 750);
        setLocation(x, y);
        setOpaque(false);

        setIcon(new ImageIcon("Castle2.png"));
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(x+20,y+25));
        points.add(new Point(x+115,y+25));
        points.add(new Point(x+115,y+110));
        points.add(new Point(x+290,y+110));
        points.add(new Point(x+290,y+20));
        points.add(new Point(x+440,y+20));
        points.add(new Point(x+getWidth() - 1,y+25));
        points.add(new Point(x+getWidth() - 1   ,y-20+getHeight()));
        points.add(new Point((int) (x+getWidth() * 0.75),y-20+getHeight()));//1
        points.add(new Point((int) (x+getWidth() * 0.75), (int) (y-20+getHeight() * 0.4)));//2
        points.add(new Point((int) (x+getWidth() * 0.25), (int) (y-20+getHeight() * 0.4)));//3
        points.add(new Point((int) (x+getWidth()* 0.25),y-20+getHeight()));//4
        points.add(new Point(x+20, y-20+getHeight()));
        points.add(new Point(x+20,y+25));


        ArrayList<Palka> palki = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            Point a = points.get(i);
            Point b = points.get(i + 1);
            Palka palka = new Palka(a, b);
            palki.add(palka);
        }

        karta = new CollisionKarta(palki);
        karta.setSize(getWidth(), getHeight());
        add(karta);

    }

}