package ru.compas;

import ru.compas.collision.CollisionKarta;
import ru.compas.collision.Palka;
import ru.compas.things.Coin;

import javax.swing.*;
import java.util.ArrayList;

public class MapLocation extends JLabel {
    CollisionKarta karta;
    ArrayList<Coin> coins;

    public MapLocation(CollisionKarta karta, ArrayList<Coin> coins) {
        this.karta = karta;
        this.coins = coins;
        add(karta);
    }
}
