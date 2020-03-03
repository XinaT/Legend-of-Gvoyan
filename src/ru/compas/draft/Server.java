package ru.compas.draft;

import ru.compas.character;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static String host;
    static void socket(String si) {


        Socket s = null;
        try {
            s = new Socket(host, 10128);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        DataOutputStream dout = null;
        try {
            dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(si);
            dout.close();
            s.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1000, 780);

        character chel = new character();
        chel.setOpaque(true);
        chel.setSize(100, 100);
        chel.setIcon(new ImageIcon("pers.png"));
        chel.setLocation(100, 100);
        frame.add(chel);

        character chel2 = new character();
        chel2.setOpaque(true);
        chel2.setSize(100, 100);
        chel2.setIcon(new ImageIcon("pers.png"));
        chel2.setLocation(200, 100);
        frame.add(chel2);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (e.getKeyCode() == KeyEvent.VK_D) {
                    chel.move("right");
                    socket("d");
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    chel.move("forward");
                    socket("w");
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    chel.move("left");
                    socket("a");
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    chel.move("toward");
                    socket("s");
                }


            }

        });

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
