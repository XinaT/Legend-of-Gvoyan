package ru.compas.network;

import ru.compas.Combo_General;

import java.io.IOException;

public class Main_GENERAL_Server {

    public static int port_of_server = 1800;
    public static void main(String[] args) {

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
