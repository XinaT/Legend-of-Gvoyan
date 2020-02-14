package com.company;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
static void socket(String si){ Socket s = null;
        try {
            s = new Socket("192.168.0.38", 6666);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        DataOutputStream dout = null;
        try {
            dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(si);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
    public static void main(String[] args) throws IOException {
        boolean a = true;

        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1000, 780);

        JButton button = new JButton();
        button.setSize(100, 50);
        button.setLocation(200, 200);

        JButton button2 = new JButton();
        button2.setSize(100, 30);
        button2.setLocation(10, 10);

        frame.add(button);
        frame.add(button2);
        frame.setVisible(true);


        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int x = button.getX();
                int y = button.getY();
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    y = y + 15;
                    button.setLocation(x, y);
                    socket("s");

                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    x = x + 15;
                    button.setLocation(x, y);
                    socket("d");


                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    y = y - 15;
                    button.setLocation(x, y);
                    socket("w");



                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    x = x - 15;
                    button.setLocation(x, y);
                    socket("a");


                }
            }

        });



    }
}
