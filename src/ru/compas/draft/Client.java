package ru.compas.draft;

import ru.compas.character;
import ru.compas.player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;


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

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                host = textField.getText();
                frame1.remove(textField);
                frame1.setVisible(false);
                frame1.remove(frame1);
                JFrame frame = new JFrame();
                frame.setLayout(null);
                frame.setSize(1000, 780);

                character chel = new character();
                chel.setOpaque(true);
                chel.setSize(100, 100);
                chel.setIcon(new ImageIcon("pers.png"));
                chel.setLocation(100, 100);
                frame.add(chel);
                frame.add(chel);
                frame.setVisible(true);
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

            }
        });


    }
}
