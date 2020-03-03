package ru.compas;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        frame.setLayout(null);

        player player = new player();
        player.setSize(100,100);
        player.setIcon(new ImageIcon("pers.png"));
        player.setLocation(100,100);
        frame.add(player);



        JLabel map = new JLabel();
        map.setSize(frame.getWidth(),frame.getHeight());
        map.setIcon(new ImageIcon("нижняя часть карты.jpg"));
        map.setOpaque(true);
        map.setLocation(0,0);
        frame.add(map);

        JLabel map1 = new JLabel();
        map1.setSize(frame.getWidth(),frame.getHeight());
        map1.setIcon(new ImageIcon("libertycityL.jpg"));
        map1.setOpaque(true);
        map1.setLocation(0,1000);
        frame.add(map1);

        ArrayList<JLabel> maps = new ArrayList<>();
        maps.add(map);
        maps.add(map1);

        controller controller = new controller(frame,player,maps);

        frame.setVisible(true);
    }
}
