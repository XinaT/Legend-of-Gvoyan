package ru.compas.collision;


public class Palka {
    Point a;
    Point b;
    boolean isVertical;
    boolean isHorizontal;

    public Palka(Point a, Point b) {
        this.a = a;
        this.b = b;

        // Палка вертикальная, если координаты x точек a и b овпадают
        isVertical = a.x == b.x;
        isHorizontal = a.y == b.y;
    }
}
