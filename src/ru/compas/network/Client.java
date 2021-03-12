package ru.compas.network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    static BufferedWriter bufferedWriter;

    public  static void Client_network_make(String server_ip, int port_server) throws IOException {

        Socket socket = new Socket(server_ip, port_server);
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

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
