package ru.compas;

import ru.compas.backpack.Backpack;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Main_GENERAL {


    public static void main(String[] args) {
        JFrame frame = creatOkno();
        Combo_General.pane = Combo_General.pane_made(frame);
        Combo_General.list_players = new ArrayList<>();

        player player = Combo_General.player_make(new ImageIcon("pers.png"), 300, 300, "I");

        MapLocation map = Combo_General.creatMap(-2000,-2000,("Правая нижняя часть карты 2.png"),frame);
        ArrayList<MapLocation> maps = new ArrayList<>();
        maps.add(map);

        controller controller = new controller(frame,player,maps);

        frame.setVisible(true);
    }


    static boolean R;
    public static JFrame creatOkno() {
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    Backpack backpack = new Backpack(frame.getWidth()/2, frame.getHeight(), new ArrayList<>());
                    if(R){
                        backpack.setVisible(false);
                        R = false;
                    }
                    else{
                    backpack.setVisible(true);
                    R = true;
                 }

                }
            }
        });
        return frame;
    }
}
