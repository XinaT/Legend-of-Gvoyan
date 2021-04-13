
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
        JFrame frame1 = new JFrame();
        frame1.setSize(500,300);
        frame1.setLocation(300,500);
        frame1.setLayout(null);
        frame1.setVisible(true);

        JLabel server_name = new JLabel();
        server_name.setSize(150, 50);
        server_name.setLocation(30, 50);
        Font font = new Font("Ticker Tape", Font.ITALIC,  14);
        server_name.setFont(font);
        server_name.setText("ip-адрес сервера: ");
        server_name.setVisible(true);
        frame1.add(server_name);


        JTextField ip = new JTextField();
        ip.setSize(200, 40);
        ip.setLocation(180, 50);
        ip.setFont(font);

        frame1.add(ip);

        // 192.168.0.153

        JButton create_server = new JButton();
        create_server.setSize(100, 100);
        create_server.setLocation(110, 150);
        create_server.setText("<html><center>"+ "Create" + "<br>" + "server"+ "</center></html>");
        create_server.setFont(font);
        create_server.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_GENERAL_Server.main(args);
                frame1.setVisible(false);
            }

        });
        frame1.add(create_server);

        JButton connect = new JButton();
        connect.setSize(100,100);
        connect.setLocation(310, 150);
        connect.setText("<html><center>"+ "Connect" + "<br>" + "server" + "</center></html>");
        connect.setFont(font);
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

    }
}
