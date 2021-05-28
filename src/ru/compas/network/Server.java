package ru.compas.network;

import ru.compas.Combo_General;
import ru.compas.controller;
import ru.compas.Pers;

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
                    Pers playerik = Combo_General.player_make("Древесный киборг.png", 350, 800,
                            socket.getInetAddress() + "", -2000, -2000);
                    Combo_General.list_players.add(playerik);
                    while (true) {
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String string = bufferedReader.readLine();

                            if (string != null) {

                                if (string.equals("Disconnect&")) {
                                    System.out.println("D");

                                    for (int i = 0; i < Combo_General.list_players.size(); i++) {
                                        if ((socket.getInetAddress() + "").equals(Combo_General.list_players.get(i).unique_code)) {
                                            Combo_General.pane.remove(Combo_General.list_players.get(i));
                                            Combo_General.list_players.remove(i);
                                            i = Combo_General.list_players.size();
                                            Combo_General.pane.repaint();
                                            rassilka();
                                        }
                                    }

                                } else {
                                    System.out.println(socket.getInetAddress() + "  " + string);
                                    int index_zvezda = string.indexOf('*');
                                    int index_probel = string.indexOf(' ');
                                    int index_sobaka = string.indexOf('@');
                                    int index_resh = string.indexOf('#');


                                    String x_str = string.substring(0, index_zvezda);
                                    String y_str = string.substring(index_zvezda + 1, index_probel);

                                    String mapX_str = string.substring(index_probel + 1, index_sobaka);
                                    String mapY_str = string.substring(index_sobaka + 1, index_resh);

                                    String name_img = string.substring(index_resh + 1, string.length() - 1);


                                    int x = Integer.valueOf(x_str);
                                    int y = Integer.valueOf(y_str);
                                    int mapX = Integer.valueOf(mapX_str);
                                    int mapY = Integer.valueOf(mapY_str);


                                    for (int i = 0; i < Combo_General.list_players.size(); i++) {
                                        if ((socket.getInetAddress() + "").equals(Combo_General.list_players.get(i).unique_code)) {

                                            if (!Combo_General.list_players.get(i).name_img.equals(name_img)) {
                                                Combo_General.setIcon(name_img, Combo_General.list_players.get(i));
                                            }

                                            controller.move_other_players(Combo_General.list_players.get(i), x, y, mapX, mapY);
                                        }
                                    }

                                }


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



            dannieOfPlayer = adress + " " + Combo_General.list_players.get(a).XNotChange + "@" +
                    Combo_General.list_players.get(a).YNotChange + "_" + Combo_General.list_players.get(a).mapX + "*"
                    + Combo_General.list_players.get(a).mapY + "#" +  Combo_General.list_players.get(a).name_img + "&";

            string = string + dannieOfPlayer;

        }

        for (int i = 0; i < socket_list.size(); i++) {

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket_list.get(i).getOutputStream()));
            bufferedWriter.write(string + "\n");
            bufferedWriter.flush();

            System.out.println("ОТПРАВЛЯЕМ     " + string);

        }


    }

    public static void rassilka_disconnect() throws IOException {
        for (int i = 0; i < socket_list.size(); i++) {

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket_list.get(i).getOutputStream()));
            bufferedWriter.write("DISC" + "\n");
            bufferedWriter.flush();

            System.out.println("ОТПРВЛЯЕМ disc");

        }
    }
}
