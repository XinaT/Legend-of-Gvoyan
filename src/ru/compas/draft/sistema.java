package ru.compas.draft;

import java.awt.*;

public class sistema {
    public boolean isPointOnPalka(Point point,Palka palka){
        float y1 = palka.a.y;
        float x1 = palka.a.x;
        float x2 = palka.b.x;
        float y2 = palka.b.y;
        float x3 = point.x;
        float y3 = point.y;
        float k = (y1 - y2)/(x1 - x2);
        float b = y3 - k*x3;

        if (y3 == k * x3 + b){
            return true;
        } else {
            return false;
        }
//        if (x3 > x2){
//            return false;
//        }
    }
}
