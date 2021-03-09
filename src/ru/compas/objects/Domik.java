package ru.compas.objects;

import ru.compas.collision.CollisionObject;

import java.awt.*;

public class Domik extends CollisionObject {
    public Domik(int x, int y, int w, int h) {
        super(x, y, w, h);
        setOpaque(true);
        setBackground(Color.black);
    }
}
