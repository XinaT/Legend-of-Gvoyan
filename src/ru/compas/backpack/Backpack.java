package ru.compas.backpack;

import org.w3c.dom.Text;
import org.w3c.dom.css.Counter;
import ru.compas.Combo_General;
import ru.compas.Main_GENERAL;
import ru.compas.things.Artefact;
import ru.compas.things.Coin;
import ru.compas.things.CounterController;
import ru.compas.things.Sword;

import javax.management.monitor.CounterMonitorMBean;
import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Backpack extends JFrame {
    public static JLabel Coins = new JLabel();
    public static JLabel Swords = new JLabel();
    public static  JLabel Bows = new JLabel();

    public static  ArrayList<Artefact> artefacts = new ArrayList<>();
    public static ArrayList<JLabel> artefactslabel = new ArrayList<>();

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

    @Deprecated
    public static void updateArtefact(int amount, Artefact artefact) {
        artefact.setText("" + amount);
        if (artefact instanceof Coin) {
            CounterController.c = amount;
        }
        else if (artefact instanceof Sword){
            CounterController.s = amount;
        }
        else {
            CounterController.b = amount;
        }

    }


    public void update() {
        //1 удалять все лейблы артефактов
        for (int i = 0; i < artefactslabel.size(); i++) {
            this.remove(artefactslabel.get(i));
        }
        //2 очищать список лейблов артефактов
        artefactslabel.clear();
        //3 (рисовать) создавать лейблы для списка артефактов и добавлять в ячейки рюкзака
        int x = 0;
        int y = 300;

        for (int j = 0; j < artefacts.size(); j++) {
            JLabel artefact = new JLabel();
            artefact.setSize(100,100);
            if (x >= this.getWidth() - artefact.getWidth()) {
                y =+ 100;
                x = 0;
            }

            artefact.setLocation(x,y);
            artefact.setVisible(true);
            artefact.setIcon(new ImageIcon(artefacts.get(j).getImageName()));
            artefactslabel.add(artefact);
            add(artefact);
            x +=100;
        }
        repaint();
    }

}
