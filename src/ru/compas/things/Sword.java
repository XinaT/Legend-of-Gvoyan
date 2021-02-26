package ru.compas.things;

import javax.swing.*;

public class Sword extends Artefact {
    public Sword(int x, int y) {
        setSize(30, 30);
        setLocation(x,y);
        setOpaque(false);
        setIcon(new ImageIcon("sword.png"));
  }
}
