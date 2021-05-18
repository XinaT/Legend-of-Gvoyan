package ru.compas.backpack;

import org.w3c.dom.Text;
import org.w3c.dom.css.Counter;
import ru.compas.Combo_General;
import ru.compas.Main_GENERAL;
import ru.compas.things.Artefact;
import ru.compas.Pers;
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
    public static JLabel Bows = new JLabel();

    public static ArrayList<Artefact> artefacts = new ArrayList<>();
    public static ArrayList<JLabel> artefactslabel = new ArrayList<>();

    public Backpack(int width, int height, ArrayList<JButton> items) throws HeadlessException {
        setSize(width, height);
        setLocation(800, 0);
        setLayout(null);
        getContentPane().setBackground(Color.getColor("#E59866"));

        JLabel avatar = new JLabel();
        avatar.setSize(100, 100);
        avatar.setLocation(20, 20);
        avatar.setOpaque(true);
        avatar.setIcon(new ImageIcon("bag.jpg"));

        add(avatar);

        Pers player = Combo_General.list_players.get(0);


        int w = 100; /// расписать оставшееся здоровье
        int x = (int) ((float) w / player.max_hp * player.hp);

        JLabel health = new JLabel();
        health.setSize(x, 20);
        health.setLocation(130, 40);
        health.setBackground(Color.red);
        health.setOpaque(true);
        add(health);

        JLabel max_health = new JLabel();
        max_health.setSize(w, 20);
        max_health.setLocation(130, 40);
        max_health.setBackground(Color.getColor("#00ff00"));
        max_health.setBackground(Color.lightGray);
        max_health.setOpaque(true);
        add(max_health);


        ///
        x = (int) ((float) w / player.max_mana * player.mana);
        JLabel mana = new JLabel();
        mana.setFocusable(false);
        mana.setSize(x, 20);
        mana.setOpaque(true);
        mana.setLocation(130, 65);
        mana.setBackground(Color.blue);
        mana.setOpaque(true);
        add(mana);

        JLabel MANA = new JLabel();
        MANA.setFocusable(false);
        MANA.setSize(w, 20);
        MANA.setLocation(130, 65);
        MANA.setOpaque(true);
        MANA.setBackground(Color.lightGray);
        add(MANA);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    setVisible(!Combo_General.R);
                    Combo_General.R = !Combo_General.R;
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
        } else if (artefact instanceof Sword) {
            CounterController.s = amount;
        } else {
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
            artefact.setSize(100, 100);
            if (x >= this.getWidth() - artefact.getWidth()) {
                y = +100;
                x = 0;
            }

            artefact.setLocation(x, y);
            artefact.setVisible(true);
            artefact.setIcon(new ImageIcon(artefacts.get(j).getImageName()));
            artefactslabel.add(artefact);
            add(artefact);
            x += 100;
        }
        repaint();
    }


}
