package ru.compas;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class character extends JLabel {

    int hp;
    int mana;
    String name;
    String abilities;
    ArrayList<player> battleUnits;

    int velocity = 20;


    public  void move(String direction) {
        int x = this.getX();
        int y = this.getY();
        if (direction.equals("right")) {
            this.setLocation(x + velocity, y);
        }
        if (direction.equals("left")) {
            this.setLocation(x - velocity, y);
        }
        if (direction.equals("forward")){
            this.setLocation(x,y - velocity);
        }
        if (direction.equals("toward")){
            this.setLocation(x,y + velocity);
        }

    }
}