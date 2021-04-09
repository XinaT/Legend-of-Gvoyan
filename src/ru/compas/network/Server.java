package ru.compas.network;

import ru.compas.Combo_General;
import ru.compas.Main_GENERAL;
import ru.compas.controller;
import ru.compas.player;

import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<Socket> socket_list = new ArrayList<>();

    public static void Server_make(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);

        while (true) {
            Socket socket = server.accept();
            socket_list.add(socket);


            Thread theard = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("CONNECT");
                    player playerik = Combo_General.player_make(new ImageIcon("Древесный киборг.png"), 350, 300,
                            socket.getInetAddress() + "", -2000, -2000);
                    Combo_General.list_players.add(playerik);
                    while (true) {
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String string = bufferedReader.readLine();

                            if (string != null) {
                                System.out.println(socket.getInetAddress() + "  " + string);
                                int index_zvezda = string.indexOf('*');
                                int index_probel = string.indexOf(' ');
                                int index_sobaka = string.indexOf('@');


                                String x_str = string.substring(0, index_zvezda);
                                String y_str = string.substring(index_zvezda + 1, index_probel);

                                String mapX_str = string.substring(index_probel + 1, index_sobaka);
                                String mapY_str = string.substring(index_sobaka + 1, string.length()-1);


                                int x = Integer.valueOf(x_str);
                                int y = Integer.valueOf(y_str);
                                int mapX = Integer.valueOf(mapX_str);
                                int mapY = Integer.valueOf(mapY_str);


                                for (int i = 0; i < Combo_General.list_players.size(); i++) {
                                    if ((socket.getInetAddress() + "").equals(Combo_General.list_players.get(i).unique_code)) {
                                        controller.move_other_players(Combo_General.list_players.get(i), x, y, mapX, mapY);
                                    }
                                }
                                rassilka();


                            }


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            theard.start();

        }

    }

    public static void rassilka() throws IOException {
        String string = "";

        for (int a = 0; a < Combo_General.list_players.size(); a++){


            String adress = "";
            String dannieOfPlayer = "";
            if (Combo_General.list_players.get(a).unique_code.equals("I")){
                adress = Combo_General.getIPOfComp();
            }else {
                adress = Combo_General.list_players.get(a).unique_code;
            }

//            dannieOfPlayer = adress + " " + Combo_General.list_players.get(a).getX() + "@" +
//                    Combo_General.list_players.get(a).getY() + "_" + Combo_General.list_players.get(a).mapX + "*"
//                    + Combo_General.list_players.get(a).mapY + "r";


            dannieOfPlayer = adress + " " + Combo_General.list_players.get(a).XNotChange + "@" +
                    Combo_General.list_players.get(a).YNotChange + "_" + Combo_General.list_players.get(a).mapX + "*"
                    + Combo_General.list_players.get(a).mapY + "r";

            string = string + dannieOfPlayer;

        }

        for (int i = 0; i < socket_list.size(); i++) {

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket_list.get(i).getOutputStream()));
            bufferedWriter.write(string + "\n");
            bufferedWriter.flush();

        }

    }
}
