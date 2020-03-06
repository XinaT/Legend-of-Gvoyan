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

    static void socket(String si, String host, int port) {


        Socket s = null;
        try {
            s = new Socket(host, port);
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

    public static void runServer(String host, int serverPort, int clientPort) throws IOException {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1000, 780);

        character chel = new character();
        chel.setSize(100, 100);
        chel.setIcon(new ImageIcon("pers.png"));
        chel.setLocation(100, 100);
        frame.add(chel);

        character chel2 = new character();
        chel2.setSize(100, 100);
        chel2.setIcon(new ImageIcon("pers.png"));
        chel2.setLocation(200, 100);
        frame.add(chel2);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (e.getKeyCode() == KeyEvent.VK_D) {
                    chel2.move("right");
                    socket("d", host, clientPort);
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    chel2.move("forward");
                    socket("w", host, clientPort);
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    chel2.move("left");
                    socket("a", host,clientPort);
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    chel2.move("toward");
                    socket("s", host, clientPort);
                }


            }

        });

        System.out.println(InetAddress.getLocalHost().getHostAddress());
        frame.setVisible(true);
        ServerSocket ss = new ServerSocket(serverPort);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();


    }

    public static void main(String[] args) throws IOException {
       runServer("localhost", 6666, 6667);

    }

}
