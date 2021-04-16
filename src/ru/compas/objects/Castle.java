package ru.compas.objects;

import ru.compas.collision.CollisionObject;

import javax.swing.*;

public class Castle extends CollisionObject {
    public Castle(int x, int y) {
        super(x, y, 150, 150);
        setLocation(x, y);
        setOpaque(false);
        setIcon(new ImageIcon(""));
    }

}