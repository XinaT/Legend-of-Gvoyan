package ru.compas.Messager;

import javax.swing.*;
import java.awt.*;

public class Message {
    ImageIcon avatar;
    String text;
    boolean isAvatarLeft;

    public Message(String text, ImageIcon avatar, boolean isAvatarLeft) {
        this.text = text;
        this.avatar = avatar;
        this.isAvatarLeft = isAvatarLeft;
    }
}