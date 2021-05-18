package ru.compas.Enemy;

import ru.compas.collision.CollisionObject;

import javax.swing.*;

public class Enemy extends CollisionObject {
    public int id;
    public int life;
    public int strong;
    public Timer agressive_timer = null;
    public JLabel voskl_znak = null;
    Timer timer_passive  = null;
    public Enemy(int x, int y, int w, int h) {
        super(x, y, w, h);
        w = 100;
        h = 100;
        setSize(w,h);
        setLocation(x,y);
        setOpaque(false);
        setIcon(new ImageIcon("Древесный киборг.png"));
        life = 50;
        strong=1;

    }
}
