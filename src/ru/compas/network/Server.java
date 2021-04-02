package ru.compas.network;

import ru.compas.Combo_General;
import ru.compas.controller;
import ru.compas.Player;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<Socket> socket_list = new ArrayList<>();

    public static void Server_make(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);

        while (true){
            Socket socket = server.accept();
            socket_list.add(socket);


            Thread theard = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("CONNECT");
                    Player playerik = Combo_General.player_make(new ImageIcon("Древесный киборг.png"), 350, 300, socket.getInetAddress()+"");
                    Combo_General.list_players.add(playerik);
                    while (true){
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String string = bufferedReader.readLine();

                            if (string!=null) {
                                System.out.println(socket.getInetAddress() + "  " + string);
                                int index_zvezda = string.indexOf('*');
                                int index_probel = string.indexOf(' ');
                                int index_sobaka = string.indexOf('@');

                                String x_str = string.substring(0, index_zvezda);
                                String y_str = string.substring(index_zvezda+1, index_probel);

                                String mapX_str = string.substring(index_probel+1, index_sobaka);
                                String mapY_str = string.substring(index_sobaka+1, string.length());



                                int x = Integer.valueOf(x_str);
                                int y = Integer.valueOf(y_str);
                                int mapX = Integer.valueOf(mapX_str);
                                int mapY = Integer.valueOf(mapY_str);


                                for (int i = 0; i < Combo_General.list_players.size(); i++){
                                    if ((socket.getInetAddress()+"").equals(Combo_General.list_players.get(i).unique_code)){
                                        controller.move_other_players(Combo_General.list_players.get(i), x, y, mapX, mapY);


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

    public static void rassilka (Player playerik, int x, int y, int mapX, int mapY) throws IOException {
        for (int i = 0; i < socket_list.size(); i++){
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket_list.get(i).getOutputStream()));
            bufferedWriter.write("RASSILKA");
            bufferedWriter.flush();
        }
    }

}
