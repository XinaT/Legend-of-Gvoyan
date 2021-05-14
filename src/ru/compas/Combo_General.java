package ru.compas;

import ru.compas.Enemy.EnemyController;
import ru.compas.backpack.Backpack;
import ru.compas.collision.CollisionKarta;
import ru.compas.collision.Palka;
import ru.compas.collision.Point;
import ru.compas.objects.CastleController;
import ru.compas.objects.Domik;
import ru.compas.objects.DomikController;
import ru.compas.objects.VolosatayaPalkaController;
import ru.compas.things.Artefact;
import ru.compas.things.ArtefactContloller;
import ru.compas.things.CounterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class Combo_General {

    public static JLayeredPane pane = null;
    public static ArrayList<Pers> list_players = null;
    public static ArrayList<MapLocation> maps = null;
    public static boolean isServer = false;
    public static JFrame frame;
    public static String imageOfI = "pers.png";
    public static boolean R = false;
    static Backpack backpack;

    public static Pers player_make(String name_img, int x, int y, String name, int mapX, int mapY) {
        ImageIcon icon = new ImageIcon(name_img);

        if (icon.getIconHeight() == -1) {
            icon = new ImageIcon("Бомж.png");
            name_img = "Бомж.png";
        }

        Pers player = new Pers();
        player.setSize(70, 70);
        player.setIcon(icon);
        player.setLocation(x, y);
        player.unique_code = name;
        pane.add(player);
        pane.setLayer(player, 5);
        player.mapX = mapX;
        player.mapY = mapY;

        player.XNotChange = x;
        player.YNotChange = y;
        player.name_img = name_img;

        player.hp = 100;
        player.strong = 5;

        return player;
    }

    public static String getIPOfComp() throws UnknownHostException {
        String res = "";
        String t = InetAddress.getLocalHost() + "";
        int index = t.indexOf("/");
//        index = index-1;
        res = t.substring(index, t.length());
        return res;
    }


    public static JFrame creatOkno() {
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLayout(null);

        return frame;
    }

    public static JFrame FrameMake(int width, int height, int x, int y) {
        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setLocation(x, y);
        frame.setLayout(null);
        frame.setVisible(true);
        return frame;
    }

    public static JLabel LabelMake(int x, int y, int width, int height, Font font, String text) {
        JLabel label = new JLabel();
        label.setSize(width, height);
        label.setLocation(x, y);
        label.setFont(font);
        label.setText(text);
        label.setVisible(true);
        label.setOpaque(true);
        return label;
    }

    public static JTextField TextFieldMake(int x, int y, int width, int height, Font font) {
        JTextField textField = new JTextField();
        textField.setSize(width, height);
        textField.setLocation(x, y);
        textField.setFont(font);
        return textField;
    }

    public static JButton ButtonMake(int x, int y, int width, int height, Font font, String text) {
        JButton button = new JButton();
        button.setSize(width, height);
        button.setLocation(x, y);
        button.setText(text);
        button.setFont(font);
        return button;
    }


    public static JLayeredPane pane_made(JFrame frame) {
        JLayeredPane pane = new JLayeredPane();
        pane.setSize(frame.getWidth(), frame.getHeight());
        pane.setLocation(0, 0);
        frame.add(pane);
        return pane;
    }

    public static MapLocation creatMap(int x, int y, String icon, JFrame frame) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(549, 0));

        points.add(new Point(549, 125));
        points.add(new Point(622, 125));
        points.add(new Point(622, 503));
        points.add(new Point(440, 503));
        points.add(new Point(440, 605));
        points.add(new Point(404, 605));
        points.add(new Point(404, 917));
        points.add(new Point(659, 917));
        points.add(new Point(659, 1054));
        points.add(new Point(769, 1054));
        points.add(new Point(769, 1261));
        points.add(new Point(1683, 1261));
        points.add(new Point(1683, 1123));


        points.add(new Point(1965, 1123));
        points.add(new Point(1961, 928));
        points.add(new Point(2075, 928));
        points.add(new Point(2075, 1123));

        points.add(new Point(2119, 1123));
        points.add(new Point(2119, 1467));
        points.add(new Point(2484, 1467));
        points.add(new Point(2484, 1535));
        points.add(new Point(2556, 1535));
        points.add(new Point(2556, 1948));
        points.add(new Point(2483, 1948));
        points.add(new Point(2483, 2498));
        points.add(new Point(2013, 2498));
        points.add(new Point(2013, 2429));
        points.add(new Point(1609, 2429));
        points.add(new Point(1609, 2396));
        points.add(new Point(1208, 2396));
        points.add(new Point(1208, 2533));
        points.add(new Point(988, 2533));
        points.add(new Point(988, 2395));
        points.add(new Point(768, 2395));
        points.add(new Point(768, 2189));
        points.add(new Point(441, 2189));
        points.add(new Point(441, 1984));
        points.add(new Point(513, 1984));
        points.add(new Point(513, 1742));
        points.add(new Point(443, 1742));
        points.add(new Point(443, 1536));
        points.add(new Point(549, 1536));
        points.add(new Point(549, 1124));
        points.add(new Point(221, 1124));
        points.add(new Point(221, 985));
        points.add(new Point(76, 985));
        points.add(new Point(76, 606));

        // чтоб палки совпадали с картой
        for (int i = 0; i < points.size(); i = i + 1) {
            Point p = points.get(i);
            p.y = p.y + 500;
        }

        ArrayList<Palka> palki = new ArrayList<>();

        for (int i = 0; i < points.size() - 1; i++) {
            Point a = points.get(i);
            Point b = points.get(i + 1);
            Palka palka = new Palka(a, b);
            palki.add(palka);
        }

        CollisionKarta karta = new CollisionKarta(palki);
        karta.setSize(3000, 4000);

        ArrayList<Artefact> all = new ArrayList<>();
        ArrayList<Artefact> coins = ArtefactContloller.createCoins();
        ArrayList<Artefact> swords = ArtefactContloller.createSwords();
        ArrayList<Artefact> bows = ArtefactContloller.createBows();
        ArrayList<Artefact> shovels = ArtefactContloller.createShovels();
        ArrayList<Artefact> compasses = ArtefactContloller.createCompasses();

        all.addAll(coins);
        all.addAll(swords);
        all.addAll(bows);
        all.addAll(shovels);
        all.addAll(compasses);

        MapLocation map = new MapLocation(karta, all);
        map.setSize(3000, 4000);
        map.setIcon(new ImageIcon(icon));
        map.setOpaque(true);
        map.setLocation(x, y);
        frame.add(map);

        JLabel vorota = new JLabel();
        vorota.setSize(200, 192);
        vorota.setVisible(true);
        vorota.setIcon(new ImageIcon("vorota.png"));
        vorota.setLocation(565, 1573);
        map.add(vorota);


        JLabel plintus = new JLabel();
        plintus.setSize(200, 192);
        plintus.setVisible(true);
        plintus.setIcon(new ImageIcon("plintus.png"));
        plintus.setLocation(1946, 1429);
        map.add(plintus);

        VolosatayaPalkaController.createVolosatayaPalka(map);
        CastleController.createCastle(map);


        map.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println(e.getX() + "," + e.getY());
            }
        });
        for (int i = 0; i < all.size(); i++) {
            Artefact artefact = all.get(i);
            map.add(artefact);
        }

        ArrayList<Domik> domiks = DomikController.createDomik();
        for (int i = 0; i < domiks.size(); i++) {
            Domik domik = domiks.get(i);
            map.add(domik);
        }

        return map;
    }

    public static void make_start(boolean isServerik) {
        frame = Combo_General.creatOkno();
        Combo_General.pane = Combo_General.pane_made(frame);
        Combo_General.isServer = isServerik;

        ArrayList<MapLocation> maps = new ArrayList<>();
        MapLocation map = Combo_General.creatMap(-750, -1900, ("Правая нижняя часть карты 2.png"), frame);
        maps.add(map);
        Combo_General.maps = maps;

        Combo_General.list_players = new ArrayList<>();
        Pers player = Combo_General.player_make(Combo_General.imageOfI, 300, 900, "I", -2000, -2000);
        Combo_General.list_players.add(player);

        Combo_General.create_backpack(frame);

        frame.setVisible(true);

        controller controller = new controller(frame, player, maps);

        CounterController.createArtefactCounter(pane);

        EnemyController.createEnemies(map);

        Timer timer = new Timer(100, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                requestOSXFullscreen(frame);
                timer.stop();
            }
        });


        timer.start();
        frame.repaint();
    }

    public static void setIcon(String name_icon, Pers player) {
        ImageIcon icon = new ImageIcon(name_icon);

        if (icon.getIconHeight() == -1) {
            icon = new ImageIcon("Бомж.png");
            name_icon = "Бомж.png";
        }
        player.name_img = name_icon;
        player.setIcon(icon);

    }


    public static void requestOSXFullscreen(Window window) {
        try {
            Class appClass = Class.forName("com.apple.eawt.Application");
            Class params[] = new Class[]{};

            Method getApplication = appClass.getMethod("getApplication", params);
            Object application = ((Method) getApplication).invoke(appClass);
            Method requestToggleFulLScreen = application.getClass().getMethod("requestToggleFullScreen", Window.class);

            requestToggleFulLScreen.invoke(application, window);

        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }


    public static void create_backpack(JFrame frame) {
        backpack = new Backpack(frame.getWidth() / 2, frame.getHeight(), new ArrayList<>());

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    backpack.setVisible(!R);
                    R = !R;
                }
            }
        });
    }
}
