package ru.compas.draft;




import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ForMapa extends JLabel {


    ArrayList<Palka> palkas;

    public ForMapa(ArrayList<Palka> palkas) {
        this.palkas = palkas;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < palkas.size(); i++) {
            Palka palka = palkas.get(i);
            g.drawLine(palka.a.x, palka.a.y, palka.b.x, palka.b.y);
        }


    }
}
