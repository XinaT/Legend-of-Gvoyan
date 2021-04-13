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
