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
    static JFrame frame;
    public static String ip_server = "";
    static int server_port = 1800;
    public static void main(String[] args) throws IOException {

            Combo_General.make_start(false);
            frame = Combo_General.creatOkno();
            Combo_General.pane = Combo_General.pane_made(frame);


            MapLocation map = Combo_General.creatMap(-2000,-2000,("Правая нижняя часть карты 2.png"),frame);
            ArrayList<MapLocation> maps = new ArrayList<>();
            maps.add(map);

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
