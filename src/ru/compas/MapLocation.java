package ru.compas;

import ru.compas.collision.CollisionKarta;
import ru.compas.collision.CollisionObject;
import ru.compas.things.Artefact;

import javax.swing.*;
import java.util.ArrayList;

public class MapLocation extends JLabel {
    public CollisionKarta karta;
    public ArrayList<CollisionObject> collisionObjects = new ArrayList<>();
    ArrayList<Artefact> artefacts;



    public MapLocation(CollisionKarta karta, ArrayList<Artefact> artefacts) {
        this.karta = karta;
        this.artefacts = artefacts;
        add(karta);
    }
}
