package ru.compas.things;

import ru.compas.backpack.Backpack;

import javax.swing.*;

public class CounterController {
    public static int c = 0;
    public static int s = 0;
    public static  int b = 0;
    public static void createArtefactCounter(JFrame frame) {

        JLabel coin = new JLabel();
        coin.setSize(50,40);
        coin.setLocation(910, 0);
        coin.setIcon(new ImageIcon("coin.png"));
        frame.add(coin);

        JLabel amountc = new JLabel();
        amountc.setSize(60,40);
        amountc.setLocation(940, 0);
        amountc.setText("Coins " + c);
        frame.add(amountc);

        JLabel sword = new JLabel();
        sword.setSize(50,40);
        sword.setLocation(910, 30);
        sword.setIcon(new ImageIcon("sword.png"));
        frame.add(sword);

        JLabel amounts = new JLabel();
        amounts.setSize(60,40);
        amounts.setLocation(930, 30);
        amounts.setText("Swords " + s);
        frame.add(amounts);

        JLabel bow = new JLabel();
        bow.setSize(50,40);
        bow.setLocation(885, 60);
        bow.setIcon(new ImageIcon("bow1.png"));
        frame.add(bow);

        JLabel amountb = new JLabel();
        amountb.setSize(60,40);
        amountb.setLocation(940, 60);
        amountb.setText("Bows "+ b);
        frame.add(amountb);

    }
}
