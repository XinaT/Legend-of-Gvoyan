package ru.compas.collision;

import javax.swing.*;

public class CollisionUtils {

    public static boolean isPersAndPalkaIntersected(JLabel pers, Palka palka_AB, JLabel label, boolean shouldTransformCoordinates) {

        int x = pers.getX();
        int y = pers.getY();

        if (shouldTransformCoordinates) {
            x = x - label.getX();
            y = y - label.getY();
        }

        Point M = new Point(x, y);
        Point N = new Point(x + pers.getWidth(), y);
        Point K = new Point(x + pers.getWidth(), y + pers.getHeight());
        Point L = new Point(x, y + pers.getHeight());

        Palka palka_MN = new Palka(M, N);
        Palka palka_NK = new Palka(N, K);
        Palka palka_KL = new Palka(K, L);
        Palka palka_LM = new Palka(L, M);

        if (isIntersected(palka_MN, palka_AB) || isIntersected(palka_NK, palka_AB) || isIntersected(palka_KL, palka_AB) || isIntersected(palka_LM, palka_AB)) {
            return true;
        } else {
            return false;
        }
    }

    public static Point getLeftPoint(Palka palka) {
        if (palka.a.x < palka.b.x) {
            return palka.a;
        } else {
            return palka.b;
        }
    }

    public static Point getRightPoint(Palka palka) {
        if (palka.a.x > palka.b.x) {
            return palka.a;
        } else {
            return palka.b;
        }
    }

    public static Point getTopPoint(Palka palka) {
        if (palka.a.y < palka.b.y) {
            return palka.a;
        } else {
            return palka.b;
        }
    }

    public static Point getDownPoint(Palka palka) {
        if (palka.a.y > palka.b.y) {
            return palka.a;
        } else {
            return palka.b;
        }
    }


    public static boolean isIntersectedVerticalHorizontal(Palka verticalPalka, Palka horizontalPalka) {
        int x = verticalPalka.a.x;
        int y = horizontalPalka.a.y;

        Point up = getTopPoint(verticalPalka);
        Point down = getDownPoint(verticalPalka);

        Point left = getLeftPoint(horizontalPalka);
        Point right = getRightPoint(horizontalPalka);

        if (left.x < x && x < right.x && up.y < y && y < down.y) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isIntersectedVerticalAndNaklon(Palka verticalPalka, Palka naklonPalka) {
        // находим уравнение прямой, на которой лежит отрезок naklonPalka
        float k = (naklonPalka.a.y - naklonPalka.b.y) / (float) (naklonPalka.a.x - naklonPalka.b.x);
        // Ya = k*Xa + b
        float b = naklonPalka.a.y - k * naklonPalka.a.x;

        int x = verticalPalka.a.x;
        int y = (int) (k * x + b);

        Point up = getTopPoint(naklonPalka);
        Point down = getDownPoint(naklonPalka);
        Point left = getLeftPoint(naklonPalka);
        Point right = getRightPoint(naklonPalka);

        Point upVertical = getTopPoint(verticalPalka);
        Point downVertical = getDownPoint(verticalPalka);

        if (upVertical.y < y && y < downVertical.y && left.x < x && x < right.x && up.y < y && y < down.y) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isIntersectedHorizontalAndNaklon(Palka horizontalPalka, Palka naklonPalka) {
        // находим уравнение прямой, на которой лежит отрезок naklonPalka
        float k = (naklonPalka.a.y - naklonPalka.b.y) / (float) (naklonPalka.a.x - naklonPalka.b.x);
        // Ya = k*Xa + b
        float b = naklonPalka.a.y - k * naklonPalka.a.x;

        int y = horizontalPalka.a.y;
        int x = (int) ((y - b) / k);

        Point up = getTopPoint(naklonPalka);
        Point down = getDownPoint(naklonPalka);
        Point left = getLeftPoint(naklonPalka);
        Point right = getRightPoint(naklonPalka);

        Point leftHorizontal = getLeftPoint(horizontalPalka);
        Point rightHorizontal = getRightPoint(horizontalPalka);

        if (leftHorizontal.x < x && x < rightHorizontal.x && left.x < x && x < right.x && up.y < y && y < down.y) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean isIntersected(Palka palka1, Palka palka2) {
        if (palka1.isHorizontal && palka2.isHorizontal) {
            // 2 горизонтальные палки не пересекаются
            return false;
        } else if (palka1.isVertical && palka2.isVertical) {
            // 2 вертикальные палки не пересекаются
            return false;
        } else if (palka1.isVertical && palka2.isHorizontal) {
            // ищем пересечение вертикальной палки и горизонтальной
            return isIntersectedVerticalHorizontal(palka1, palka2);
        } else if (palka1.isHorizontal && palka2.isVertical) {
            // ищем пересечение горизонтальной палки и вертикальной
            return isIntersectedVerticalHorizontal(palka2, palka1);
        } else if (palka1.isVertical) { // вторая палка наклонная
            // ищем пересечение вертикальной палки и наклонной
            return isIntersectedVerticalAndNaklon(palka1, palka2);
        } else if (palka1.isHorizontal) { // вторая палка наклонная
            // ищем пересечение горизонтальной палки и наклонной
            return isIntersectedHorizontalAndNaklon(palka1, palka2);
        } else {
            // считаем, что других случаев у нас не бывает
            return false;
        }
    }

}
