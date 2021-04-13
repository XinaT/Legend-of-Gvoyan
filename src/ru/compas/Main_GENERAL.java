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

