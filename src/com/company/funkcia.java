package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class funkcia {
    static int a = 5;
    public static void main(String[] args) {
        JFrame frame = creatOkno();
        JLabel house = creatDomik(100,100);
        creat2Domika(200,200,700,200,frame);
        frame.add(house);


        frame.setVisible(true);

    }

    static JFrame creatOkno(){
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        return frame;

    }

    static JLabel creatDomik(int x, int y){
        JLabel house = new JLabel();
        house.setLocation(x,y);
        house.setSize(200,200);
        house.setIcon(new ImageIcon("Домик.png"));
        return house;

    }

    static void creat2Domika(int x, int y, int x2, int y2, JFrame frame){
        JLabel house = creatDomik(x,y);
        JLabel house2 = creatDomik(x2,y2);
        frame.add(house);
        frame.add(house2);
    }

    static void MPS(){
        JFrame frame = creatOkno();

        JLabel label = new JLabel();
        label.setLocation(500,500);
        label.setSize(100,100);
        label.setOpaque(true);
        label.setBackground(Color.GREEN);
        label.setIcon(new ImageIcon("pers.png"));

        Timer timer = new Timer(30, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = label.getX();
                int y = label.getY();




                if (x > 700) {
                    a = -a;
                } else if (x < 300){
                    a = -a;
                }

                label.setLocation(x + a, y);

            }
        });
        timer.start();
        frame.add(label);
    }

}
