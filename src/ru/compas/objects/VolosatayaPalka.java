package ru.compas.objects;

import ru.compas.collision.CollisionObject;

import javax.swing.*;

public class VolosatayaPalka extends CollisionObject {
    public VolosatayaPalka(int x, int y, int w, int h) {
        super(x, y, w, h);
        setLocation(x, y);
        setOpaque(false);
        setIcon(new ImageIcon("Дерево.png"));
    }
}






