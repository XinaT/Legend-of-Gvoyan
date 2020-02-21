package ru.compas.draft;

import javax.swing.*;
import java.awt.*;

public class verticalnaya_palka {
    static void isIntersected(JLabel pers, Palka palka) {

    }

    static boolean isPointOnVerticalPalka(Point point, Palka palka) {
        if(palka.a.x == palka.b.x && (palka.a.y < point.y || point.y < palka.a.y)) {
            return true;
        } else if(palka.b.x == palka.a.x && (palka.b.y < point.y || point.y < palka.a.y)){
            return true;
        } else {
            return false;
        }
    }

    static boolean isPointOnHorizontalPalka(Point point, Palka palka) {
        if(palka.a.y == palka.b.y && (palka.a.x < point.x || point.x < palka.a.x)) {
            return true;
        } else if(palka.b.y == palka.a.y && (palka.b.x < point.x || point.x < palka.b.x)){
            return true;
        } else {
            return false;
        }
    }

    static boolean isPalkaVertical(Palka palka) {
        if(palka.a.x == palka.b.x) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isPalkaOnHorizontal(Palka palka) {
        if(palka.a.y == palka.b.y) {
            return true;
        } else {
            return false;
        }
    }
}
