package ru.compas.things;

import javax.swing.*;

public class Bow extends Artefact {
    public Bow(int x, int y) {
        setSize(71, 40);
        setLocation(x, y);
        setOpaque(false);
        setIcon(new ImageIcon("bow1.png"));
    }
}
