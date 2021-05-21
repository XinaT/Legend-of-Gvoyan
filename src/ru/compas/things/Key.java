package ru.compas.things;

import javax.swing.*;

public class Key extends Artefact {
    public Key(int x, int y) {
        setSize(60, 60);
        setLocation(x,y);
        setOpaque(false);
        setIcon(new ImageIcon("key.png"));
    }
    @Override
    public String getImageName() {
        return "key.png";
    }
}
