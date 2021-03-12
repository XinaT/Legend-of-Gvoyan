package ru.compas.things;

import javax.swing.*;
import java.awt.*;

public class Domik extends JLabel {
    public Domik(int x, int y) {
        setSize(250, 250);
        setLocation(x,y);
        setOpaque(false);
        setIcon(new ImageIcon("Домик.png"));
    }

}
