package ru.compas.things;

import javax.swing.*;

public class Coin extends Artefact {
    public Coin(int x, int y) {
        setSize(30, 30);
        setLocation(x,y);
        setOpaque(false);
        setIcon(new ImageIcon("coin.png"));
    }
    @Override
    public String getImageName() {
        return "coin.png";
    }
}
