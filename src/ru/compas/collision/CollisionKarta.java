package ru.compas.collision;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CollisionKarta extends JLabel {

    public ArrayList<Palka> palki;

    public CollisionKarta(ArrayList<Palka> palki) {
        this.palki = palki;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < palki.size(); i++) {
            Palka palka = palki.get(i);
            g.drawLine(palka.a.x, palka.a.y,palka.b.x, palka.b.y);
        }
    }
}
