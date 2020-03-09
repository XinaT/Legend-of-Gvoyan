package ru.compas;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        JFrame frame = creatOkno();

        player player = player();
        frame.add(player);

        JLabel map = creatMap(0,0,("нижняя часть карты.jpg"),frame);

        JLabel map2 = creatMap(0,1000,("images-1.jpeg"),frame);

        JLabel map3 = creatMap(1000,1000,("images-2.jpeg"),frame);

        JLabel map4 = creatMap(1000,0,("images-3.jpeg"),frame);

        JLabel map5 = creatMap(-1000,-1000,("images-4.jpeg"),frame);

        JLabel map6 = creatMap(0,-1000,("images-5.jpeg"),frame);

        JLabel map7 = creatMap(-1000,0,("images-6.jpeg"),frame);

        JLabel map8 = creatMap(-1000,1000,("images-7.jpeg"),frame);

        JLabel map9 = creatMap(1000,-1000,("libertycityL.jpg"),frame);


        ArrayList<JLabel> maps = new ArrayList<>();
        maps.add(map);
        maps.add(map2);
        maps.add(map3);
        maps.add(map4);
        maps.add(map5);
        maps.add(map6);
        maps.add(map7);
        maps.add(map8);
        maps.add(map9);

        controller controller = new controller(frame,player,maps);

        frame.setVisible(true);
    }
    public static JFrame creatOkno(){
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        return frame;
    }

    public static player player(){
        player player = new player();
        player.setSize(100,100);
        player.setIcon(new ImageIcon("pers.png"));
        player.setLocation(100,100);
        return player;
    }

    public static JLabel creatMap(int x,int y, String icon, JFrame frame){
        JLabel map = new JLabel();
        map.setSize(frame.getWidth(),frame.getHeight());
        map.setIcon(new ImageIcon(icon));
        map.setOpaque(true);
        map.setLocation(x,y);
        frame.add(map);
        return map;

    }
}
