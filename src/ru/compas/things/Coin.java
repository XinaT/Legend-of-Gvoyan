package ru.compas.things;

import javax.swing.*;

public class Coin extends JLabel {
    public Coin(int x, int y) {
        setSize(30, 30);
        setLocation(x,y);
        setOpaque(false);
        setIcon(new ImageIcon("coin.png"));
    }
}
