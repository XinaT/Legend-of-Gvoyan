package ru.compas.things;

import javax.swing.*;

public class BuriedArtefact extends Artefact {
    public BuriedArtefact(int x,int y) {
        setSize(30, 30);
        setLocation(x,y);
        setVisible(true);
        setOpaque(false);
        setIcon(new ImageIcon("coin.png"));
    }
    @Override
    public String getImageName() {
        return "coin.png";
    }
}
