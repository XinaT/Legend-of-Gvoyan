package ru.compas.draft;

import ru.compas.player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static ru.compas.draft.main.chel;

public class playKeybints {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        frame.setLayout(null);

        JLabel labelmap = new JLabel();
        labelmap.setSize(4659, 3050);
        labelmap.setLocation(0, 0);
        labelmap.setOpaque(true);
        labelmap.setVisible(true);
        labelmap.setIcon(new ImageIcon("libertycityL.jpg"));

        JLabel label = new JLabel();
        label.setLocation(500,500);
        label.setSize(100,100);
        label.setVisible(true);
        label.setOpaque(true);
        label.setBackground(Color.CYAN);

        JLabel label2 = new JLabel();
        label2.setLocation(500, 300);
        label2.setSize(100,100);
        label2.setVisible(true);
        label2.setOpaque(true);
        label2.setBackground(Color.RED);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int x =label.getX();
                int y =label.getY();
                int x2 =labelmap.getX();
                int y2 =labelmap.getY();
//                if (x > 250 && y > 250 && x < 750 && y < 750) {
//                    x = label.getX();
//                    y = label.getY();
//                    if (e.getKeyCode() == KeyEvent.VK_W) {
//                        label.setLocation(x,y - 10);
//                    }else if (e.getKeyCode() == KeyEvent.VK_S) {
//                        label.setLocation(x,y + 10);
//                    }else if (e.getKeyCode() == KeyEvent.VK_A) {
//                        label.setLocation(x - 10,y);
//                    }else if (e.getKeyCode() == KeyEvent.VK_D) {
//                        label.setLocation(x + 10, y);
//                    }
//                } else {
//                    int x2 =labelmap.getX();
//                    int y2 =labelmap.getY();
//                    if (e.getKeyCode() == KeyEvent.VK_W) {
//                        labelmap.setLocation(x2, y2 + 10);
//                    } else if (e.getKeyCode() == KeyEvent.VK_S) {
//                        labelmap.setLocation(x2, y2 - 10);
//                    } else if (e.getKeyCode() == KeyEvent.VK_A) {
//                        labelmap.setLocation(x2 + 10, y2);
//                    } else if (e.getKeyCode() == KeyEvent.VK_D) {
//                        labelmap.setLocation(x2 - 10, y2);
//                    }
//                }

                if (x > 250 && e.getKeyCode() == KeyEvent.VK_A) {
                    label.setLocation(x - 10,y);
                }else if (x < 750 && e.getKeyCode() == KeyEvent.VK_D) {
                    label.setLocation(x + 10,y);
                }else if (y < 750 && e.getKeyCode() == KeyEvent.VK_S) {
                    label.setLocation(x,y + 10);
                }else if (y > 250 && e.getKeyCode() == KeyEvent.VK_W) {
                    label.setLocation(x,y - 10);
                }else if (x <= 250 && e.getKeyCode() == KeyEvent.VK_A) {//
                    labelmap.setLocation(x2 + 10,y2);
                }else if (x >= 750 && e.getKeyCode() == KeyEvent.VK_D) {
                    labelmap.setLocation(x2 - 10,y2);
                }else if (y >= 750 && e.getKeyCode() == KeyEvent.VK_S) {
                    labelmap.setLocation(x2,y2 - 10);
                }else if (y <= 250 && e.getKeyCode() == KeyEvent.VK_W) {
                    labelmap.setLocation(x2,y2 + 10);

                }

//                intersect(label, label2);
            }
        });
        frame.add(label);
        frame.add(label2);
        frame.add(labelmap);
        frame.setVisible(true);

    }

    static void intersect(JLabel label, JLabel label2) {
        int x1 = label.getX();
        int y1 = label.getY();
        int x2 = label2.getX();
        int y2 = label2.getY();

        if (x1 < x2 && y1 < y2 || x1 < x2 && y1 == y2 || x1 < x2 && y1 > y2 || x1 == x2 && y1 > y2 || x1 > x2 && y1 > y2 || x1 > x2 && y1 == y2 || x1 > x2 && y1 < y2 || x1 == x2 && y1 < y2) {
            System.out.println("Hello I'm Tom!");
        } else {
            System.out.println("No intersect");
        }

    }
}
