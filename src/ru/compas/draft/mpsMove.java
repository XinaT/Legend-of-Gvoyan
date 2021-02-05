package ru.compas.draft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;


public class mpsMove {
    static int a = 5;
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        frame.setLayout(null);

        JLabel label = new JLabel();
        label.setLocation(500,500);
        label.setSize(100,100);
        label.setVisible(true);
        label.setOpaque(true);
        label.setBackground(Color.GREEN);

        JLabel label2 = new JLabel();
        label2.setLocation(900,500);
        label2.setSize(100,100);
        label2.setVisible(false);
        label2.setOpaque(true);
        label2.setBackground(Color.white);

        JLabel label3 = new JLabel();
        label3.setLocation(200,500);
        label3.setSize(100,100);
        label3.setVisible(false);
        label3.setOpaque(true);
        label3.setBackground(Color.white);

        Timer timer = new Timer(1, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = label.getX();
                int y = label.getY();




                    if (x > 800) {
                        a = -a;
                    } else if (x < 300){
                        a = -a;
                    }

                label.setLocation(x + a, y);

            }
        });
        timer.start();








        frame.add(label);
        frame.add(label2);
        frame.add(label3);
        frame.setVisible(true);
    }
}
