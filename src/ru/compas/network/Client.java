package ru.compas.network;

import java.io.*;
import java.net.Socket;

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
                while (true) {
                    try {
                        String string = bufferedReader.readLine();
                        if (string!=null) {
                            System.out.println(string);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        thread.start();

    }

    public static void send_to_server(String text) throws IOException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    bufferedWriter.write(text + "\n");
                    bufferedWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }
}
