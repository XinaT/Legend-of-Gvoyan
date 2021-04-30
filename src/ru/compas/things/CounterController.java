package ru.compas.things;

import ru.compas.Combo_General;
import ru.compas.backpack.Backpack;

import javax.swing.*;
import java.awt.*;

public class CounterController {
    public static int c = 0;
    public static int s = 0;
    public static  int b = 0;
    public static void createArtefactCounter(JLayeredPane pane) {

        JLabel coin = new JLabel();
        coin.setSize(50,40);
        coin.setLocation(910, 0);
        coin.setIcon(new ImageIcon("coin.png"));
        pane.add(coin);


        JLabel amountc = new JLabel();
        amountc.setSize(60,40);
        amountc.setLocation(940, 0);
        amountc.setText("Coins " + c);
        pane.add(amountc);

        JLabel sword = new JLabel();
        sword.setSize(50,40);
        sword.setLocation(910, 30);
        sword.setIcon(new ImageIcon("sword.png"));
        pane.add(sword);

        JLabel amounts = new JLabel();
        amounts.setSize(60,40);
        amounts.setLocation(930, 30);
        amounts.setText("Swords " + s);
        pane.add(amounts);

        JLabel bow = new JLabel();
        bow.setSize(50,40);
        bow.setLocation(885, 60);
        bow.setIcon(new ImageIcon("bow1.png"));
        pane.add(bow);

        JLabel amountb = new JLabel();
        amountb.setSize(60,40);
        amountb.setLocation(940, 60);
        amountb.setText("Bows "+ b);
        pane.add(amountb);

        JLabel amount_pers_life = new JLabel();
        amount_pers_life.setSize(80,40);
        amount_pers_life.setLocation(900, 90);
        amount_pers_life.setText("Жизнь:  "+ Combo_General.list_players.get(0).hp);
        pane.add(amount_pers_life);


    }
}
