package ru.compas;

import ru.compas.Enemy.EnemyController;
import ru.compas.network.Client;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.IOException;
import java.util.ArrayList;

public class Main_GENERAL {
    static JFrame frame;
    public static Pers player;
    static String ip_server = "192.168.0.115";
    static int server_port = 1800;
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
        Combo_General.isServer = false;

        // создание контроллера персонажа, который отвечает за перемещение и за коллизии
        controller controller = new controller(frame,player,maps);

        EnemyController.createEnemies(map);

        frame.setVisible(true);
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
