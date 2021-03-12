package ru.compas.network;

import ru.compas.Combo_General;
import ru.compas.Main_GENERAL;
import ru.compas.player;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void Server_make(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);

        while (true){
            Socket socket = server.accept();

            Thread theard = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("CONNECT");
                    player playerik = Combo_General.player_make(new ImageIcon("Древесный киборг.png"), 350, 300, socket.getInetAddress()+"");
                    Main_GENERAL_Server.list_players.add(playerik);
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




                                for (int i = 0; i < Main_GENERAL_Server.list_players.size(); i++){
                                    if ((socket.getInetAddress()+"").equals(Main_GENERAL_Server.list_players.get(i).unique_code)){
//                                        Main_GENERAL_Server.list_players.get(i).setLocation(x, y);
                                        Server_controller.move_other_players(Main_GENERAL_Server.list_players.get(i), x, y, mapX, mapY);

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

}
