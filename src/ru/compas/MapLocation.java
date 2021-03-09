package ru.compas;

import ru.compas.collision.CollisionKarta;
import ru.compas.collision.CollisionObject;
import ru.compas.collision.Palka;

import javax.swing.*;
import java.util.ArrayList;

public class MapLocation extends JLabel {
    CollisionKarta karta;
    ArrayList<CollisionObject> collisionObjects = new ArrayList<>();

    public MapLocation(CollisionKarta karta) {
        this.karta = karta;
        add(karta);
    }
}
