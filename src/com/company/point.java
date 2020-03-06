package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class point {
    int x;
    int y;

    public point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class palka {
    point a;
    point b;


    public palka(point a, point b) {
        this.a = a;
        this.b = b;
    }


    public static void main(String[] args) {
        ArrayList<point> points = new ArrayList<>();
        points.add(new point(100, 100));
        points.add(new point(200, 100));
        points.add(new point(300, 100));
        points.add(new point(400, 100));
        points.add(new point(500, 100));
        points.add(new point(600, 100));
        points.add(new point(700, 100));
        points.add(new point(800, 100));
        points.add(new point(900, 100));
        points.add(new point(1000, 100));


        ArrayList<palka> palkas = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            point a = points.get(i);
            point b = points.get(i + 1);
            palka palka = new palka(a, b);

        }
    }



    static void isIntersectet(JLabel label, palka palka){

        int x = label.getX();
        int wx = label.getWidth();
        int y = label.getY();
        int hy = label.getHeight();
        int x2 = palka.a.x;
        int y2 = palka.a.y;
        int x3 = palka.b.x;
        int y3 = palka.b.y;


        if (x2 > x && y2 > y && x2 < wx && y2 < hy && x3 > x && y3 > y && x2 < wx && y3 < hy) {

        }
    }




}




