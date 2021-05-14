package ru.compas.objects;

import ru.compas.MapLocation;

import javax.swing.*;
import java.awt.*;

public class CastleController {
    public static Castle castle = new Castle(1752,1800);
    public static JLabel label = new JLabel();

    public CastleController(MapLocation map) {
    }

    public static void createCastle(MapLocation map) {
        int w =castle.getWidth();
        label.setSize( w/3, 100);
        label.setLocation(castle.getX()+ w/3, castle.getY()+castle.getHeight() - 100);
        label.setOpaque(false);
        label.setLayout(null);
        map.add(label);
        map.add(castle);
    }

}
