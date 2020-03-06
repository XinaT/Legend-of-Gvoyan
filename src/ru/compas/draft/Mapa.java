package ru.compas.draft;

import ru.compas.draft.Palka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Mapa {

    static ArrayList<Point> colliderPoints = new ArrayList<>() {{
        add(new Point(549,3));
        add(new Point(549,125));
        add(new Point(622,125));
        add(new Point(622,503));
        add(new Point(440,503));
        add(new Point(440,605));
        add(new Point(404,605));
        add(new Point(404,917));
        add(new Point(659,917));
        add(new Point(659,1054));
        add(new Point(769,1054));
        add(new Point(769,1261));
        add(new Point(1683,1261));
        add(new Point(1683,1123));
        add(new Point(2119,1123));
        add(new Point(2119,1467));
        add(new Point(2484,1467));
        add(new Point(2484,1535));
        add(new Point(2556,1535));
        add(new Point(2556,1948));
        add(new Point(2483,1948));
        add(new Point(2483,2498));
        add(new Point(2013,2498));
        add(new Point(2013,2429));
        add(new Point(1609,2429));
        add(new Point(1609,2396));
        add(new Point(1208,2396));
        add(new Point(1208,2533));
        add(new Point(988,2533));
        add(new Point(988,2395));
        add(new Point(768,2395));
        add(new Point(768,2189));
        add(new Point(441,2189));
        add(new Point(441,1984));
        add(new Point(513,1984));
        add(new Point(513,1742));
        add(new Point(443,1742));
        add(new Point(443,1536));
        add(new Point(549,1536));
        add(new Point(549,1124));
        add(new Point(221,1124));
        add(new Point(221,985));
        add(new Point(76,985));
        add(new Point(76,606));

    }};


    public static void main(String[] args) {
        //для всех точек
        // создать линии между текущей точкой и следующей
        // запихнуть в линию эти точки (a, b)
        JFrame v1 = new JFrame();
        v1.setVisible(true);
        v1.setSize(822, 1162);


        int i = 0;
        for (i = 0; i < 11; i++) {
            System.out.println(i);
        }

        ArrayList<Palka> palkas = new ArrayList<>();
        for (int j = 0; j < colliderPoints.size() - 1; j++) {
//            Palka palka = new Palka(colliderPoints.get(j), colliderPoints.get(j + 1));
//            palkas.add(palka);
        }


        ForMapa formapa = new ForMapa(palkas);
        formapa.setSize(1000,1000);
        v1.add(formapa);

        JLabel labelV1 = new JLabel();
        labelV1.setSize(822, 1162);
        labelV1.setVisible(true);
        labelV1.setIcon(new ImageIcon("Правая нижняя часть карты 2.png"));
        v1.add(labelV1);
        v1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                e.getX();
                e.getY();
                System.out.println((e.getX() - labelV1.getX())  + " " + (e.getY() -labelV1.getY()));
            }
        });
        v1.repaint();


        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String point = scanner.nextLine().replace(" ", ",");
            System.out.println("add(new Point(" + point + "));");
        }



    }

//    static int isIntersected(JLabel )
}
