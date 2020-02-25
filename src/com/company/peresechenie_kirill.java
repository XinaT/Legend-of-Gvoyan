package com.company;

import javax.swing.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
    }
}
class Line {
    Point a;
    Point b;


    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }
}

    public class peresechenie_kirill {
        static void isInntersected(JLabel pers, Line line) {

        }

        static boolean isPointOnHorizontalLine(Point point, Line line) {
            Point c;
            Point d;

            if (line.a.x < line.b.x) {
                c = line.a;
                d = line.b;
            } else {
                c = line.b;
                d = line.a;
            }

            if (point.y == c.y && point.y == d.y && point.x >= c.x && point.x <= d.x){
                return true;
            } else {
                return false;
            }
        }

        static boolean isPointOnVerticalLine(Point point, Line line){
            Point c;
            Point d;

            if (line.a.y < line.b.y) {
                c = line.a;
                d = line.b;
            } else {
                c = line.b;
                d = line.a;
            }

            if (point.x == c.x && point.x == d.x && point.y >= c.y && point.y <= d.y) {
                return true;
            } else {
                return false;
            }
        }

        static boolean isLineHorizontal(Line line){
            if (line.a.y == line.b.y) {
                return true;
            } else {
                return false;
            }
        }

        static boolean isLineVertical(Line line) {
            if (line.a.x == line.b.x) {
                return true;
            }else {
                return false;
            }
        }

        static boolean isPointOnLine(Point point, Line line) {
            if (isLineHorizontal(line)) {
                return isPointOnHorizontalLine(point, line);
            } else if (isLineVertical(line)) {
                return isPointOnVerticalLine(point, line);
            } else {
                return false;
            }
        }

        static boolean isPointOnPers(Point point, JLabel label) {
            Point A = new Point(label.getX(), label.getY());
            Point B = new Point(label.getX(), label.getY());
            Point C = new Point(label.getX(), label.getY());
            Point D = new Point(label.getX(), label.getY());

            Line line = new Line(A, B);
            Line line2 = new Line(B, C);
            Line line3 = new Line(C, D);
            Line line4 = new Line(D, A);

            if (isPointOnLine(point,line) || isPointOnLine(point,line2) || isPointOnLine(point,line3) || isPointOnLine(point,line4)){
                return true;
            } else {
                return false;
            }
        }


    }

