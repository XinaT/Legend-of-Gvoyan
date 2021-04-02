package ru.compas.things;

import ru.compas.MapLocation;
import ru.compas.Player;

import javax.swing.*;
import java.util.ArrayList;

public class ArtefactContloller extends JLabel {
    public static ArrayList<Artefact> createBows() {
        ArrayList<Artefact> bows = new ArrayList<>();

        Bow bow1 = new Bow(2200, 2100);
        bows.add(bow1);

        return bows;
    }
    public static ArrayList<Artefact> createSwords() {
        ArrayList<Artefact> swords = new ArrayList<>();

        Sword sword1 = new Sword(2000, 2100);
        swords.add(sword1);

        return swords;
    }

    public static ArrayList<Artefact> createCoins() {
    ArrayList<Artefact> coins = new ArrayList<>();

    Coin coin1 = new Coin(2000, 2850);
        coins.add(coin1);

    Coin coin2 = new Coin(2000, 3000);
        coins.add(coin2);

    Coin coin3 = new Coin(600, 1500);
        coins.add(coin3);

    Coin coin4 = new Coin(2500, 3000);
        coins.add(coin4);

    Coin coin5 = new Coin(2000, 2000);
        coins.add(coin5);

    Coin coin6 = new Coin(250, 2000);
        coins.add(coin6);

    Coin coin7 = new Coin(10, 10);
        coins.add(coin7);

    Coin coin8 = new Coin(10, 11);
        coins.add(coin8);

    Coin coin9 = new Coin(10, 12);
        coins.add(coin9);

    Coin coin10 = new Coin(10, 13);
        coins.add(coin10);

    Coin coin11 = new Coin(10, 14);
        coins.add(coin11);

    Coin coin12 = new Coin(10, 15);
        coins.add(coin12);

    Coin coin13 = new Coin(10, 16);
        coins.add(coin13);

    Coin coin14 = new Coin(10, 17);
        coins.add(coin14);

    Coin coin15 = new Coin(10, 18);
        coins.add(coin15);

        return coins;
}

    public static boolean isIntersected(Player player, Artefact artefact, MapLocation map) {
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
