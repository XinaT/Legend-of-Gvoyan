package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Point> colliderPoints = new ArrayList<>() {{
        add(new Point(61, 25));
        add(new Point(61, 145));
        add(new Point(149, 146));
        add(new Point(151, 205));
        add(new Point(170, 206));
        add(new Point(170, 314));
        add(new Point(121, 315));
        add(new Point(120, 344));
        add(new Point(111, 345));
        add(new Point(111, 436));
        add(new Point(180, 436));
        add(new Point(181, 475));
        add(new Point(211, 476));
        add(new Point(211, 535));
        add(new Point(462, 535));
        add(new Point(462, 496));
        add(new Point(580, 496));
        add(new Point(580, 595));
        add(new Point(680, 596));
        add(new Point(681, 615));
        add(new Point(700, 615));
        add(new Point(700, 734));
        add(new Point(681, 734));
        add(new Point(680, 894));
        add(new Point(552, 893));
        add(new Point(551, 875));
        add(new Point(442, 875));
        add(new Point(441, 865));
        add(new Point(331, 864));
        add(new Point(331, 904));
        add(new Point(272, 905));
        add(new Point(271, 865));
        add(new Point(212, 865));
        add(new Point(212, 805));
        add(new Point(122, 805));
        add(new Point(122, 746));
        add(new Point(141, 746));
        add(new Point(141, 675));
        add(new Point(122, 675));
        add(new Point(121, 616));
        add(new Point(151, 615));
        add(new Point(151, 495));
        add(new Point(62, 495));
        add(new Point(61, 455));
        add(new Point(22, 455));
        add(new Point(21, 345));
        add(new Point(4, 344));
        add(new Point(67, 785));
    }};


    public static void main(String[] args) {
        //для всех точек
        // создать линии между текущей точкой и следующей
        // запихнуть в линию эти точки (a, b)
        JFrame v1 = new JFrame();
        v1.setVisible(true);
        v1.setSize(822, 1162);
        v1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                e.getX();
                e.getY();
                System.out.println(e.getX() + " " + e.getY());
            }
        });

        int i = 0;
        for (i = 0; i < 11; i++) {
            System.out.println(i);
        }

        ArrayList<Palka> palkas = new ArrayList<>();
        for (int j = 0; j < colliderPoints.size() - 1; j++) {
            Palka palka = new Palka(colliderPoints.get(j), colliderPoints.get(j + 1));
            palkas.add(palka);
        }


        JLabel labelV1 = new JLabel();
        labelV1.setSize(822, 1162);
        labelV1.setVisible(true);
        labelV1.setIcon(new ImageIcon("Правая нижняя часть карты 2.png"));
        v1.add(labelV1);

        v1.repaint();


        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String point = scanner.nextLine().replace(" ", ",");
            System.out.println("add(new Point(" + point + "));");
        }


    }
}
