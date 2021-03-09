package ru.compas;

import ru.compas.collision.CollisionKarta;
import ru.compas.collision.Palka;

import javax.swing.*;
import java.util.ArrayList;

public class MapLocation extends JLabel {
    public CollisionKarta karta;

    public MapLocation(CollisionKarta karta) {
        this.karta = karta;
        add(karta);
    }
}
