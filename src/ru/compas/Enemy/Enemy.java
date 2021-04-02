package ru.compas.Enemy;

import javax.swing.*;

public class Enemy extends JLabel {
    public Enemy(int x, int y){
        setSize(100,100);
        setLocation(x,y);
        setOpaque(false);
        setIcon(new ImageIcon("Древесный киборг.png"));
    }

}
