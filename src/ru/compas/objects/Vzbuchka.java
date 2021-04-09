package ru.compas.objects;

import ru.compas.collision.CollisionObject;

import javax.swing.*;

public class Vzbuchka extends CollisionObject {
    public Vzbuchka(int x, int y) {
        super(x, y, 100, 100);
        setLocation(x, y);
        setOpaque(false);
        setVisible(true);
        setIcon(new ImageIcon("tenor-unscreen.gif"));
    }
}
