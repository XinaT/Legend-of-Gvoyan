package ru.compas;

import ru.compas.collision.CollisionKarta;
import ru.compas.collision.CollisionObject;
import ru.compas.collision.Palka;
import ru.compas.things.Artefact;
import ru.compas.things.Coin;

import javax.swing.*;
import java.util.ArrayList;

public class MapLocation extends JLabel {
    CollisionKarta karta;
    ArrayList<CollisionObject> collisionObjects = new ArrayList<>();
    ArrayList<Artefact> artefacts;


    public MapLocation(CollisionKarta karta, ArrayList<Artefact> artefacts) {
        this.karta = karta;
        this.artefacts = artefacts;
        add(karta);
    }
}
