package ru.compas.collision;

import javax.swing.*;
import java.util.ArrayList;

public class CollisionObject extends JLabel {

    public CollisionKarta karta;

    public CollisionObject(int x, int y, int w, int h) {

        setSize(w, h);
        setLocation(x, y);
        updateCollision();
    }

    public void updateCollision(){
        ArrayList<Point> points = new ArrayList<>();
        int x = getX();
        int y = getY();

        points.add(new Point(x, y));
        points.add(new Point(getWidth() + x, y));
        points.add(new Point(getWidth() + x, getHeight() + y));
        points.add(new Point(x, getHeight() + y));
        points.add(new Point(x, y));


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
