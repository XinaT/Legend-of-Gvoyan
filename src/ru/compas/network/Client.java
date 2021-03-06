package ru.compas.network;

import ru.compas.Combo_General;
import ru.compas.Pers;
import ru.compas.controller;


import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Client {
    static BufferedWriter bufferedWriter;
    static BufferedReader bufferedReader;

    public  static void Client_network_make(String server_ip, int port_server) throws IOException {

        Socket socket = new Socket(server_ip, port_server);
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (Combo_General.isConnected) {
                    try {
                        String string = bufferedReader.readLine();
                        if (string!=null && Combo_General.isConnected) {
                            if (string.equals("DISC")){
                                Combo_General.isConnected = false;

                                while (Combo_General.list_players.size() > 1){
                                    Combo_General.pane.remove(Combo_General.list_players.get(1));
                                    Combo_General.list_players.remove(1);
                                }
                                Combo_General.pane.repaint();

                            }else {
                                checkNewOldPlayer(string);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        thread.start();

    }

    public static void checkNewOldPlayer(String dannie) throws UnknownHostException {
        ArrayList<Pers> listPlayerNew = new ArrayList<>();
        listPlayerNew.add(Combo_General.list_players.get(0));
        String IPOfI = Combo_General.getIPOfComp();
        boolean stop = false;

        String[] list_dannie = dannie.split("&");

        for (int i = 0; i < list_dannie.length; i++){
            int indexProbel = list_dannie[i].indexOf(' ');
            int indexSobaka = list_dannie[i].indexOf('@');
            int indexNizPodch = list_dannie[i].indexOf('_');
            int indexZvezda = list_dannie[i].indexOf('*');
            int indexResh = list_dannie[i].indexOf('#');

            String ip = list_dannie[i].substring(0, indexProbel);
            String playerX_str = list_dannie[i].substring(indexProbel+1, indexSobaka);
            String playerY_str = list_dannie[i].substring(indexSobaka+1, indexNizPodch);
            String mapX_str = list_dannie[i].substring(indexNizPodch+1, indexZvezda);
            String mapY_str = list_dannie[i].substring(indexZvezda+1, indexResh);
            String name_img = list_dannie[i].substring(indexResh+1);

            int playerX = Integer.valueOf(playerX_str);
            int playerY = Integer.valueOf(playerY_str);
            int mapX = Integer.valueOf(mapX_str);
            int mapY = Integer.valueOf(mapY_str);

            System.out.println(ip + " " + playerX + " " + playerY + " " + mapX + " " + mapY);

            if (!ip.equals(IPOfI)) {
                for (int c = 0; c < Combo_General.list_players.size(); c++) {
                    if (ip.equals(Combo_General.list_players.get(c).unique_code)) {
                        controller.move_other_players(Combo_General.list_players.get(c),
                                playerX, playerY, mapX, mapY);
                        listPlayerNew.add(Combo_General.list_players.get(c));
                        stop = true;
                    }
                }
                if (!stop) {

                    Pers playerik = Combo_General.player_make(name_img,
                            playerX, playerY, ip, mapX, mapY);
                    listPlayerNew.add(playerik);

                }
            }
        }
        for (int i = 0; i < Combo_General.list_players.size(); i++){
            boolean yes = false;
            String u_c = Combo_General.list_players.get(i).unique_code;
            for (int b = 0; b < listPlayerNew.size(); b++){
                if (u_c.equals(listPlayerNew.get(b).unique_code)){
                    yes = true;
                }
            }

            if (!yes){
                Combo_General.pane.remove(Combo_General.list_players.get(i));
            }



        }
        Combo_General.list_players = listPlayerNew;
    }



    public static void send_to_server(String text) throws IOException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                     String textik = text + "&";
                    System.out.println(textik);
                    bufferedWriter.write(textik + "\n");
                    bufferedWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }
}
