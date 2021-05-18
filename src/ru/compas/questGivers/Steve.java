package ru.compas.questGivers;

import ru.compas.collision.CollisionObject;

import javax.swing.*;

public class Steve extends CollisionObject {
     public Steve() {
         super(1050, 2050, 70, 115);
        setOpaque(false);
        setIcon(new ImageIcon("Квестодатель который за пятёрочкой.png"));
    }
}
