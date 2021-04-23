package ru.compas.things;

import ru.compas.MapLocation;
import ru.compas.Pers;

import javax.swing.*;
import java.util.ArrayList;

public class ArtefactContloller extends JLabel {
    public static ArrayList<Artefact> createBows() {

        ArrayList<Artefact> bows = new ArrayList<>();
        Bow bow1 = new Bow(2200, 2100);
        Bow bow2 = new Bow(2270, 2300);
        Bow bow3 = new Bow(1500, 2100);
        Bow bow4 = new Bow(2200, 2100);

        bows.add(bow1);
        bows.add(bow2);
        bows.add(bow3);
        bows.add(bow4);

        return bows;
    }
    public static ArrayList<Artefact> createSwords() {
        ArrayList<Artefact> swords = new ArrayList<>();

        Sword sword1 = new Sword(2000, 2300);
        swords.add(sword1);

        return swords;
    }

    public static ArrayList<Artefact> createCoins() {
    ArrayList<Artefact> coins = new ArrayList<>();

    Coin coin1 = new Coin(934, 2857);
        coins.add(coin1);

    Coin coin2 = new Coin(549, 2346);
        coins.add(coin2);

    Coin coin3 = new Coin(1526, 2861);
        coins.add(coin3);

    Coin coin4 = new Coin(2434, 2962);
        coins.add(coin4);

    Coin coin5 = new Coin(621, 1451);
        coins.add(coin5);

    Coin coin6 = new Coin(1700, 1783);
        coins.add(coin6);


        return coins;
}

    public static boolean isIntersected(Pers player, Artefact artefact, MapLocation map) {
        int a = player.getY() - (artefact.getY() + map.getY());
        int b = player.getX() - (artefact.getX() + map.getX());
        int S = (int) Math.sqrt(a * a + b * b);
        if (S < player.getWidth()) {
            return true;
        } else {
            return false;
        }
    }

}
