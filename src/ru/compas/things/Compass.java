package ru.compas.things;

import javax.swing.*;

public class Compass extends Artefact {
    public Compass(int x, int y) {
        setSize(30, 30);
        setLocation(x, y);
        setOpaque(false);
        setIcon(new ImageIcon("compass.png"));
    }

    @Override
    public String getImageName() {
        return "compass.png";

    }
}
