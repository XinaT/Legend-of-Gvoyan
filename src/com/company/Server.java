package com.company;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        int x = 200;
        int y = 200;
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1000, 780);
        JButton button = new JButton();
        button.setSize(100, 30);
        button.setLocation(x, y);
        frame.add(button);
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        frame.setVisible(true);
        ServerSocket ss = new ServerSocket(6666);
        while (true) {
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = dis.readUTF();
            if (str.equals("w")) {
                y = y - 15;
                button.setLocation(x,y);
            } else if (str.equals("a")) {
                x = x - 15;
                button.setLocation(x,y);
            } else if (str.equals("d")) {
                x = x + 15;
                button.setLocation(x,y);
            } else if (str.equals("s")) {
                y = y + 15;
                button.setLocation(x,y);
            }
        }


    }

}
