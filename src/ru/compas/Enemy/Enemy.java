package ru.compas.Enemy;

import ru.compas.collision.CollisionObject;

import javax.swing.*;

public class Enemy extends CollisionObject {
    public int life;
    public Enemy(int x, int y, int w, int h) {
        super(x, y, w, h);
        w = 100;
        h = 100;
        setSize(w,h);
        setLocation(x,y);
        setOpaque(false);
        setIcon(new ImageIcon("Древесный киборг.png"));
    }
}
