package ru.compas.objects;

import ru.compas.collision.CollisionKarta;
import ru.compas.collision.Palka;
import ru.compas.collision.Point;

import javax.swing.*;
import java.util.ArrayList;

public class Domik extends JLabel {

    CollisionKarta karta;

    public Domik(int x,int y) {


        ArrayList<Point> points = new ArrayList<>();

        points.add(new Point(0, 0));
        points.add(new Point(getWidth(), 0));
        points.add(new Point(getWidth(), getHeight()));
        points.add(new Point(0, getHeight()));
        points.add(new Point(0, 0));


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
        karta = new CollisionKarta(palki);

    }

}
