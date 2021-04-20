
import ru.compas.Combo_General;
import ru.compas.Main_GENERAL;
import ru.compas.network.Client;
import ru.compas.network.Main_GENERAL_Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {

        JFrame frame1 = Combo_General.FrameMake(500, 500, 300, 500);
        Font font = new Font("Ticker Tape", Font.ITALIC,  14);

        JLabel server_name = Combo_General.LabelMake(30, 50, 150, 50, font, "ip-адрес сервера: ");
        frame1.add(server_name);

        JTextField ip = Combo_General.TextFieldMake(180, 50, 200, 40, font);
        frame1.add(ip);

        // 192.168.0.153

        JButton create_server = Combo_General.ButtonMake(110, 150, 100, 100, font,
                "<html><center>"+ "Create" + "<br>" + "server"+ "</center></html>");

        create_server.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_GENERAL_Server.main(args);
                frame1.setVisible(false);
            }

        });

        frame1.add(create_server);

        JButton connect = Combo_General.ButtonMake(310, 150, 100, 100, font,
                "<html><center>"+ "Connect" + "<br>" + "server" + "</center></html>");

        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main_GENERAL.ip_server = ip.getText() + "";
                    System.out.println(Main_GENERAL.ip_server + "");
                    Main_GENERAL.main(args);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                frame1.setVisible(false);
            }
        });
        frame1.add(connect);
        frame1.repaint();

        JLabel avatar_text = Combo_General.LabelMake(70, 370, 100, 50, font, "Ваш аватар: ");
        frame1.add(avatar_text);

        JButton avatar_img = Combo_General.ButtonMake(200, 350, 100, 100, font, "");
//        avatar_img.setBackground(Color.white);
        avatar_img.setIcon(new ImageIcon(Combo_General.imageOfI));

        frame1.add(avatar_img);

        JButton avatar_change = Combo_General.ButtonMake(350, 350, 100, 100, font,
                "<html><center>"+ "Сменить" + "<br>" + "аватар"+ "</center></html>");
        frame1.add(avatar_change);

        avatar_change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame2 = Combo_General.FrameMake(500, 350, 200, 200);

                JButton button1 = Combo_General.ButtonMake(50, 50, 100, 100, font, "");
                button1.setIcon(new ImageIcon("pers.png"));
                frame2.add(button1);

                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Combo_General.imageOfI = "pers.png";
                        avatar_img.setIcon(new ImageIcon("pers.png"));
                        frame2.setVisible(false);
                    }
                });

                JButton button2 = Combo_General.ButtonMake(200, 50, 100, 100, font, "");
                button2.setIcon(new ImageIcon("tree_monster.png"));
                frame2.add(button2);

                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Combo_General.imageOfI = "tree_monster.png";
                        avatar_img.setIcon(new ImageIcon("tree_monster.png"));
                        frame2.setVisible(false);
                    }
                });

                JButton button3 = Combo_General.ButtonMake(350, 50, 100, 100, font, "");
                button3.setIcon(new ImageIcon("Дух цветов.png"));
                frame2.add(button3);

                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Combo_General.imageOfI = "Дух цветов.png";
                        avatar_img.setIcon(new ImageIcon("Дух цветов.png"));
                        frame2.setVisible(false);
                    }
                });

                JButton button4 = Combo_General.ButtonMake(50, 200, 100, 100, font, "");
                button4.setIcon(new ImageIcon("Охотник.png"));
                frame2.add(button4);

                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Combo_General.imageOfI = "Охотник.png";
                        avatar_img.setIcon(new ImageIcon("Охотник.png"));
                        frame2.setVisible(false);
                    }
                });

                JButton button5 = Combo_General.ButtonMake(200, 200, 100, 100, font, "");
                button5.setIcon(new ImageIcon("Торговщик.png"));
                frame2.add(button5);

                button5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Combo_General.imageOfI = "Торговщик.png";
                        avatar_img.setIcon(new ImageIcon("Торговщик.png"));
                        frame2.setVisible(false);
                    }
                });

                JButton button6 = Combo_General.ButtonMake(350, 200, 100, 100, font, "");
                button6.setIcon(new ImageIcon("Болотный Лягуш.png"));
                frame2.add(button6);

                button6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Combo_General.imageOfI = "Болотный Лягуш.png";
                        avatar_img.setIcon(new ImageIcon("Болотный Лягуш.png"));
                        frame2.setVisible(false);
                    }
                });



            }
        });



        frame1.repaint();





    }
}
