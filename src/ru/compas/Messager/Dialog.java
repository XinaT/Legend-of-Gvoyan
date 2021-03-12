package ru.compas.Messager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Dialog extends JLabel {
    Message message;
    ArrayList<Message> messages;
    int index = 0;


    public Dialog(ArrayList<Message> msgs) {
        this.message = msgs.get(0);
        this.messages = msgs;
        setSize(900, 190);
        setLocation(0, 800);
        setBackground(Color.white);
        setOpaque(true);
        JLabel label = new JLabel();
        label.setLocation(100, 0);
        label.setSize(800, 100);
        JLabel avatar = new JLabel();
        avatar.setSize(100, 100);
        avatar.setLocation(0, 0);
        JButton button = new JButton();
        button.setLocation(100, 100);
        button.setSize(100, 50);
        button.setText("Next");
        button.setFocusable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (index == messages.size()) {
                    setVisible(false);
                    return;
                }

                avatar.setIcon(messages.get(index).avatar);

                label.setText(messages.get(index).text);
                index++;

            }
        });
        if (message.isAvatarLeft) {
            avatar.setLocation(0, 0);
        } else {
            avatar.setLocation(getWidth() - avatar.getWidth(), 0);
        }
        add(label);
        add(avatar);
        add(button);
    }

    public void setMessages(ArrayList<Message> messages) {
        this.message = messages.get(0);
        this.messages = messages;
        index = 0;
    }

}
