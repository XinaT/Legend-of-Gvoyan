package ru.compas.objects;

import ru.compas.collision.CollisionKarta;
import ru.compas.collision.CollisionObject;
import ru.compas.collision.Palka;
import ru.compas.collision.Point;

import javax.swing.*;
import java.util.ArrayList;

public class VolosatayaPalka extends CollisionObject {
    public VolosatayaPalka(int x, int y, int w, int h) {
        super(x, y, w, h);
        setLocation(x, y);
        setOpaque(false);
        setIcon(new ImageIcon("Дерево.png"));

        ArrayList<Point> points = new ArrayList<>();

        points.add(new Point(x + getWidth() / 4, y + getHeight() / 4));
        points.add(new Point(x + 3*w/4 , y + h/4 ));
        points.add(new Point(x + 3*w/4 , y + 3*h/4 ));
        points.add(new Point(x + w/4 , y + 3*h/4 ));
        points.add(new Point(x + getWidth() / 4, y + getHeight() / 4));


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