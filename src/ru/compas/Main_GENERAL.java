package ru.compas;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Main_GENERAL {
    static JFrame frame;
    public static Player player;

    public static void main(String[] args) throws IOException {

        frame = Combo_General.creatOkno();
        Combo_General.pane = Combo_General.pane_made(frame);

        Combo_General.list_players = new ArrayList<>();
        player = Combo_General.player_make(new ImageIcon("pers.png"), 300, 300, "I");
        Combo_General.create_backpack(frame);
        Combo_General.list_players.add(player);

        MapLocation map = Combo_General.creatMap(-2000, -2000, ("Правая нижняя часть карты 2.png"), frame);
        ArrayList<MapLocation> maps = new ArrayList<>();
        maps.add(map);

        Combo_General.maps = maps;

        controller controller = new controller(frame,player,maps);
        frame.setVisible(true);
    }
}

