package ru.compas.things;

import javax.swing.*;

public class CounterController {
    public static void createArtefactCounter(JFrame frame) {
        int a = 0;
        int b = 0;
        int c = 0;
        JLabel label11 = new JLabel();
        label11.setSize(50,40);
        label11.setLocation(910, 0);
        label11.setIcon(new ImageIcon("coin.png"));
        frame.add(label11);

        JLabel label21 = new JLabel();
        label21.setSize(50,40);
        label21.setLocation(940, 0);
        label21.setText("Coins");
        frame.add(label21);

        JLabel label31 = new JLabel();
        label31.setSize(50,40);
        label31.setLocation(980, 0);
        label31.setText("" + a);
        frame.add(label31);

        JLabel label12 = new JLabel();
        label12.setSize(50,40);
        label12.setLocation(910, 30);
        label12.setIcon(new ImageIcon("sword.png"));
        frame.add(label12);

        JLabel label22 = new JLabel();
        label22.setSize(50,40);
        label22.setLocation(930, 30);
        label22.setText("Swords");
        frame.add(label22);

        JLabel label32 = new JLabel();
        label32.setSize(50,40);
        label32.setLocation(980, 30);
        label32.setText("" + b);
        frame.add(label32);

        JLabel label13 = new JLabel();
        label13.setSize(50,40);
        label13.setLocation(885, 60);
        label13.setIcon(new ImageIcon("bow1.png"));
        frame.add(label13);

        JLabel label23 = new JLabel();
        label23.setSize(50,40);
        label23.setLocation(940, 60);
        label23.setText("Bows");
        frame.add(label23);

        JLabel label33 = new JLabel();
        label33.setSize(50,40);
        label33.setLocation(980, 60);
        label33.setText("" + c);
        frame.add(label33);





    }
}
