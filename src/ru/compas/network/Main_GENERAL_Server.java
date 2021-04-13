package ru.compas.network;

import ru.compas.Combo_General;
import ru.compas.MapLocation;
import ru.compas.controller;
import ru.compas.Pers;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main_GENERAL_Server {
    static int port_of_server = 1800;
//    static JFrame frame;
    public static void main(String[] args) throws IOException {
        Combo_General.make_start(true);



//        frame = Combo_General.creatOkno();
//        Combo_General.pane = Combo_General.pane_made(frame);
//        Combo_General.isServer = true;



//        ArrayList<MapLocation> maps = new ArrayList<>();
//        MapLocation map = Combo_General.creatMap(-2000,-2000,("Правая нижняя часть карты 2.png"),frame);
//        maps.add(map);
//        Combo_General.maps = maps;


//        Combo_General.list_players = new ArrayList<>();
//        Pers player = Combo_General.player_make(new ImageIcon("pers.png"), 300, 300, "I", -2000, -2000);
//        Combo_General.list_players.add(player);

//        frame.setVisible(true);
//
//        controller controller = new controller(frame, player, maps);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Server.Server_make(port_of_server);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }
}
