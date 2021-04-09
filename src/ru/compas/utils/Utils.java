package ru.compas.utils;

import javax.swing.*;

public class Utils {


    // если shouldTransformCoordinates true, то label2 находится на coordinateSystem
    // это значит, что нужно преобразовать координаты label1 к системе coordinateSysytem (map)
    public static double distanceBetween(JLabel label1, JLabel label2, JLabel coordinateSystem, boolean shouldTransformCoordinates) {
        int x1, x2, y1, y2;

        double dis;

        x1 = label1.getX();
        y1 = label1.getY();
        x2 = label2.getX();
        y2 = label2.getY();

        if (shouldTransformCoordinates) {
            x1 = x1 - coordinateSystem.getX();
            y1 = y1 - coordinateSystem.getY();
        }

        dis = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return dis;
    }

}
