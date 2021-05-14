package ru.compas.objects;

import ru.compas.collision.CollisionObject;

import javax.swing.*;

public class Larek extends CollisionObject {
    public Larek(int x, int y) {
        super(x, y, 500, 404);
        setLocation(x, y);
        setOpaque(false);
        setIcon(new ImageIcon("Larek.png"));
    }
}