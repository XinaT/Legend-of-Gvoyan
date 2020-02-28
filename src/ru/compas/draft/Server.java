package ru.compas.draft;

import ru.compas.character;

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

        character chel = new character();
        chel.setOpaque(true);
        chel.setSize(100, 100);
        chel.setIcon(new ImageIcon("pers.png"));
        chel.setLocation(100, 100);
        frame.add(chel);
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        frame.setVisible(true);
        ServerSocket ss = new ServerSocket(6666);
        while (true) {
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = dis.readUTF();
            if (str.equals("w")) {
               chel.move("forward");
            } else if (str.equals("a")) {
                chel.move("left");
            } else if (str.equals("d")) {
               chel.move("right");
            } else if (str.equals("s")) {
               chel.move("toward");
            }
        }


    }

}
