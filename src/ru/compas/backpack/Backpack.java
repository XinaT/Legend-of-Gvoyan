package ru.compas.backpack;

import org.w3c.dom.Text;
import ru.compas.Combo_General;
import ru.compas.Main_GENERAL;
import ru.compas.things.Coin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Backpack extends JFrame {
    static JLabel Coins = new JLabel();

    public Backpack(int width, int height, ArrayList<JButton> items) throws HeadlessException {
        setSize(width, height);
        setLocation(800, 0);
        setLayout(null);
        getContentPane().setBackground(Color.getColor("#E59866"));

        JButton avatar = new JButton();
        avatar.setFocusable(false);
        avatar.setSize(100, 100);
        avatar.setLocation(20, 20);
        avatar.setOpaque(true);
        avatar.setIcon(new ImageIcon(""));

        add(avatar);

        JButton HEALTH = new JButton();
        HEALTH.setFocusable(false);
        HEALTH.setSize(115, 20);
        HEALTH.setLocation(130, 40);
        HEALTH.setBackground(Color.gray);
        add(HEALTH);

        int w = 0; /// расписать оставшееся здоровье
        JButton health = new JButton();
        health.setFocusable(false);
        health.setSize(w, 20);
        health.setLocation(130, 40);
        health.setBackground(Color.getColor("#EE430C"));
        health.setOpaque(true);
        add(health);

        JButton MANA = new JButton();
        MANA.setFocusable(false);
        MANA.setSize(115, 20);
        MANA.setLocation(130, 65);
        MANA.setBackground(Color.gray);
        MANA.setOpaque(true);
        add(MANA);

        int m = 0; ///
        JButton mana = new JButton();
        mana.setFocusable(false);
        mana.setSize(m, 20);
        mana.setLocation(130, 65);
        mana.setOpaque(true);
        add(mana);


        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    if (Combo_General.R) {
                        setVisible(false);
                        Combo_General.R = false;
                    }
                }
            }
        });

        Coins.setSize(80, 80);
        Coins.setLocation(20, 150);
        Coins.setIcon(new ImageIcon("coin.png"));
        //Coins.setFont();
        Coins.setVisible(true);
        add(Coins);


        int y = 300;
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < getWidth(); j = j + 100) {
                items.get(i).setLocation(j, y);
            }
            y = y + 100;
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 300; i < getHeight(); i = i + 100) {
            g.drawLine(0, i, getWidth(), i);
        }
        for (int i = 0; i < getWidth(); i = i + 100) {
            g.drawLine(i, 300, i, getHeight());
        }

    }

    public static void updateCoins(int coins) {
        Coins.setText("" + coins);

    }
}
