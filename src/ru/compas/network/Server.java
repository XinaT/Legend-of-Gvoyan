package ru.compas.network;

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
                    while (true){
                        try {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String string = bufferedReader.readLine();
                            System.out.println(string);
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
