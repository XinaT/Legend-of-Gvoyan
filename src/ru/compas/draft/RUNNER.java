package ru.compas.draft;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class RUNNER {


    static void run(int port1, int port2,String host) {
        try {
            Server.runServer(host, port1, port2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String... args) {
        start();
        start();
    }

    public static void start() {
        JFrame frame = new JFrame();
        frame.setSize(1000, 800);
        frame.setLayout(null);

        JTextField textField = new JTextField();
        textField.setSize(200, 70);
        textField.setLocation(100, 100);
        textField.setVisible(true);

        JTextField textField2 = new JTextField();
        textField2.setSize(200, 70);
        textField2.setLocation(400, 100);
        textField2.setVisible(true);

        JTextField textField3 = new JTextField();
        textField3.setSize(200, 70);
        textField3.setLocation(700, 100);
        textField3.setVisible(true);

        JButton button = new JButton();
        button.setLocation(220, 250);
        button.setSize(300, 80);
        button.setText("START");
        button.setVisible(true);
        try {
            System.out.println(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run(Integer.valueOf(textField.getText()), Integer.valueOf(textField2.getText()),textField3.getText());

            }
        });
        frame.add(button);
        frame.add(textField);
        frame.add(textField2);
        frame.add(textField3);
        frame.setVisible(true);
    }
}
