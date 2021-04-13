package ru.compas;

import ru.compas.Enemy.EnemyController;
import ru.compas.network.Client;
import ru.compas.objects.VolosatayaPalkaController;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Main_GENERAL {
    public static Pers player;
    static String ip_server = "192.168.0.141";
    static int server_port = 1800;
        static JFrame frame;

        public static void main(String[] args) throws IOException {
            Combo_General.make_start(false);

//            frame = Combo_General.creatOkno();
//            Combo_General.pane = Combo_General.pane_made(frame);
//            Combo_General.isServer = false;


//        MapLocation map = Combo_General.creatMap(-2000, -2000, ("Правая нижняя часть карты 2.png"), frame);
//        ArrayList<MapLocation> maps = new ArrayList<>();
//        maps.add(map);


//        Combo_General.list_players = new ArrayList<>();
//        Pers player = Combo_General.player_make(new ImageIcon("pers.png"), 300, 300, "I", -2000, -2000);
//        Combo_General.list_players.add(player);
//        Combo_General.create_backpack(frame);

//        Combo_General.maps = maps;


            // создание контроллера персонажа, который отвечает за перемещение и за коллизии
//            controller controller = new controller(frame, player, maps);

//            EnemyController.createEnemies(map);


//            frame.setVisible(true);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Client.Client_network_make(ip_server, server_port);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }

    }

