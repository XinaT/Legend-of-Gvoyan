package ru.compas;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1641,1162);
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

        controller controller = new controller(frame,player,map);

        frame.setVisible(true);
    }
}
