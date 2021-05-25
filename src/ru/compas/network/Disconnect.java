package ru.compas.network;

import ru.compas.Combo_General;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Disconnect extends JFrame {
    public Disconnect(int x, int y, int width, int height){
        setSize(width, height);
        setLocation(x, y);
        setLayout(null);

        JButton button_exit = Combo_General.ButtonMake(250, 10, 50, 50, new Font("Ticker Tape", Font.ITALIC,  14), "X");
        add(button_exit);

        button_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton button_disconnect = Combo_General.ButtonMake(50, 100, 150, 100, new Font("Ticker Tape", Font.ITALIC,  14), "ОТКЛЮЧИТЬСЯ");
        add(button_disconnect);

        button_disconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Combo_General.isConnected = false;
                try {
                    Client.send_to_server("Disconnect");
                    while (Combo_General.list_players.size() > 1){
                        Combo_General.pane.remove(Combo_General.list_players.get(1));
                        Combo_General.list_players.remove(1);
                    }
                    Combo_General.pane.repaint();

                    if (Combo_General.isServer){
                        Server.rassilka_disconnect();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });


    }
}
