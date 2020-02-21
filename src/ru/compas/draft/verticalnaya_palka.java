package ru.compas.draft;

import javax.swing.*;
import java.awt.*;

public class verticalnaya_palka {
    static void isIntersected(JLabel pers, Palka palka) {

    }

    static boolean isPointOnPalka(Point point, Palka palka) {
        if(palka.a.x == palka.b.y && palka.a.y < point.y || point.y < palka.a.x) {
            return true;
        } else if(palka.b.x == palka.a.y && palka.b.y < point.y || point.y < palka.b.x){
            return true;
        } else {
            return false;
        }
    }
}
