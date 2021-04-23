package ru.compas.things;

import javax.swing.*;

public class Shovel extends Artefact {
    public Shovel(int x, int y) {
        setSize(60, 60);
        setLocation(x, y);
        setOpaque(false);
        setIcon(new ImageIcon("shovel.png"));
    }

    @Override
    public String getImageName() {
        return "shovel.png";

    }
}
