package ru.compas;

import ru.compas.network.Client;

import javax.swing.*;
import java.io.IOException;

public class Main_GENERAL {

    public static String ip_server = "";
    public static int server_port = 1800;

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
