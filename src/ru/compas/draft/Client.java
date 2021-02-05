package ru.compas.draft;

import ru.compas.character;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Client {


    static String host;

    static void socket(String si) {


        Socket s = null;
        try {
            s = new Socket(host, 6666);
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
        JFrame frame1 = new JFrame();
        frame1.setLayout(null);
        frame1.setSize(1000, 780);


        JTextField textField = new JTextField();
        textField.setLocation(500, 500);
        textField.setSize(300, 300);
        JButton button = new JButton();
        button.setLocation(50, 50);
        button.setSize(100, 70);
        button.setText("IP Введен");

        frame1.add(textField);
        textField.add(button);
        frame1.setVisible(true);
        textField.setVisible(true);
        button.setVisible(true);

        System.out.println(InetAddress.getLocalHost().getHostAddress());

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                host = textField.getText();
                frame1.remove(textField);
                frame1.setVisible(false);
                frame1.remove(frame1);
                try {
                    runClient();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

        });


    }

    public static void runClient() throws IOException {

        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1000, 780);

        character chel2 = new character();
        chel2.setSize(100, 100);
        chel2.setIcon(new ImageIcon("pers.png"));
        chel2.setLocation(300, 100);

        character chel = new character();
        chel.setSize(100, 100);
        chel.setIcon(new ImageIcon("pers.png"));
        chel.setLocation(100, 100);

        frame.add(chel2);
        frame.add(chel);
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                System.out.println("Client move");
                if (e.getKeyCode() == KeyEvent.VK_D) {

                    chel2.move("right");
                    socket("d");
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    chel2.move("forward");
                    socket("w");
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    chel2.move("left");
                    socket("a");
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    chel2.move("toward");
                    socket("s");
                }

            }

        });

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        ServerSocket ss = null;
                        ss = new ServerSocket(10128);
                        Socket s = ss.accept();
                        DataInputStream dis = null;
                        dis = new DataInputStream(s.getInputStream());
                        String str = null;
                        str = dis.readUTF();
                        if (str.equals("w")) {
                            chel.move("forward");
                        } else if (str.equals("a")) {
                            chel.move("left");
                        } else if (str.equals("d")) {
                            chel.move("right");
                        } else if (str.equals("s")) {
                            chel.move("toward");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();
    }


}
