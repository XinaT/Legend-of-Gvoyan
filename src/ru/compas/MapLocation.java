package ru.compas;

import ru.compas.collision.CollisionKarta;
import ru.compas.collision.CollisionObject;
import ru.compas.things.Artefact;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MapLocation extends JLabel {
    private CollisionKarta karta;
    private ArrayList<CollisionObject> collisionObjects = new ArrayList<>();
    ArrayList<Artefact> artefacts;


    public MapLocation(CollisionKarta karta, ArrayList<Artefact> artefacts) {
        this.karta = karta;
        this.artefacts = artefacts;
        add(karta);
    }

    @Override
    public Component add(Component comp) {
        if (comp instanceof CollisionObject) {
            CollisionObject object = (CollisionObject) comp;
            collisionObjects.add(object);
        }
        return super.add(comp);
    }

    public ArrayList<CollisionObject> getCollisionObjects() {
        return collisionObjects;
    }

    public CollisionKarta getKarta() {
        return karta;
    }
}
