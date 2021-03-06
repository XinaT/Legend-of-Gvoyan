package ru.compas.objects;

import ru.compas.collision.CollisionKarta;
import ru.compas.collision.CollisionObject;
import ru.compas.collision.Palka;
import ru.compas.collision.Point;

import javax.swing.*;
import java.util.ArrayList;

public class Larek extends CollisionObject {
    public Larek(int x, int y) {
        super(x, y, 500, 404);
        setLocation(x, y);
        setOpaque(false);
        setIcon(new ImageIcon("Larek.png"));

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0,0));
        points.add(new Point(0,500));
        points.add(new Point(500,404));
        points.add(new Point(404,500));
        points.add(new Point(500,404));
        points.add(new Point(0,0));



        ArrayList<Palka> palki = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            Point a = points.get(i);
            Point b = points.get(i + 1);
            Palka palka = new Palka(a, b);
            palki.add(palka);
        }

        karta = new CollisionKarta(palki);
    }
}