package ru.compas.Enemy;

import ru.compas.Combo_General;
import ru.compas.MapLocation;
import ru.compas.Pers;
import ru.compas.collision.CollisionObject;
import ru.compas.collision.CollisionUtils;
import ru.compas.collision.Palka;
import ru.compas.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EnemyController {
    public static void createEnemies(MapLocation map) {
        Enemy enemy1 = new Enemy(1500, 2200, 100, 100);
        map.add(enemy1);
//        setEnemyMovement(enemy1, map);
        setPassiveMode(enemy1, map);

        Enemy enemy2 = new Enemy(1700, 2200, 100, 100);
        map.add(enemy2);
//        setEnemyMovement(enemy2, map);
        setPassiveMode(enemy2, map);

        Enemy enemy3 = new Enemy(1800, 2200, 100, 100);
        map.add(enemy3);
//        setEnemyMovement(enemy3, map);
        setPassiveMode(enemy3, map);
    }


    public static void setPassiveMode(Enemy enemy, MapLocation map) {
        if (enemy.voskl_znak!=null) {
            map.remove(enemy.voskl_znak);
        }
        Timer timer = new Timer(1000, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Pers player = Combo_General.list_players.get(0);
                double distanceBetween = Utils.distanceBetween(player, enemy, map, true);
                if (distanceBetween < 300) {
                    setReadyMode(player, enemy, map);
                    timer.stop();
                }
            }
        });
        timer.start();
    }

    static void setReadyMode(Pers player, Enemy enemy, MapLocation map) {
        JLabel label = new JLabel();
        label.setSize(50, 50);
        label.setLocation(enemy.getX() + 20,  enemy.getY() - 25);
        label.setOpaque(false);
        label.setIcon(new ImageIcon("angry.png"));
        map.add(label);
        label.repaint();
        enemy.voskl_znak = label;


        Timer timer = new Timer(3000, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Pers player = Combo_General.list_players.get(0);
                double distanceBetween = Utils.distanceBetween(player, enemy, map, true);
                if (distanceBetween < 300) {
                    setAggressiveMode(player, enemy, map);
                } else {
                    setPassiveMode(enemy, map);
                }
                timer.stop();
                Utils.removeFromMap(label, map);
            }
        });
        timer.start();

    }

    static void setAggressiveMode(Pers player, Enemy enemy, MapLocation map) {
        if (enemy.voskl_znak!=null) {
            map.remove(enemy.voskl_znak);
        }
        Timer timer = new Timer(30, null);
        enemy.agressive_timer = timer;
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                double xe = enemy.getX();
//                double ye = enemy.getY();
//                double xp = player.getX();
//                double yp = player.getY();
//
//                xp = xp - map.getX();
//                yp = yp - map.getY();
//
//                double incline = ((xp - xe) / (yp - ye));
//
//                double v = 5;
//
//                double y;
//                y = v / Math.sqrt(incline * incline + 1);
//                double x;
//                x = y * incline;
//
//                if (xp > xe && yp > ye) {
//                    //ничего не надо делать
//                } else if (xp > xe && yp < ye) {
//                    x = -x;
//                    y = -y;
//                } else if (xp < xe && yp < ye) {
//                    y = -y;
//                    x = -x;
//                }
//
//
//                int rx = (int) (x + xe);
//                int ry = (int) (y + ye);
//
//                enemy.setLocation(rx, ry);
//                enemy.updateCollision();
                int Xenemy = enemy.getX();
                int Yenemy = enemy.getY();
                int Xplayer = player.getX() - map.getX();
                int Yplayer = player.getY() - map.getY();

                int XenemyRes = 0;
                int YenemyRes = 0;
                int shag = 3;

                if (Xenemy > Xplayer){
                    XenemyRes = Xenemy  - shag;
                } else if(Xenemy < Xplayer){
                    XenemyRes = Xenemy + shag;
                } else{
                    XenemyRes = Xenemy;
                }

                if (Yenemy > Yplayer){
                    YenemyRes = Yenemy - shag;
                } else if(Yenemy < Yplayer){
                    YenemyRes = Yenemy + shag;
                } else{
                    YenemyRes = Yenemy;
                }

                enemy.setLocation(XenemyRes, YenemyRes);
                enemy.updateCollision();
            }
        });
        timer.start();
    }


    static void setEnemyMovement(Enemy enemy, MapLocation map) {
        Timer timer = new Timer(30, null);
        timer.addActionListener(new ActionListener() {

            int sign = 1;

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int x = enemy.getX();
                int y = enemy.getY();

                boolean isUdarilsya = false;
                for (int i = 0; i < map.getCollisionObjects().size(); i++) {
                    CollisionObject object = map.getCollisionObjects().get(i);
                    for (int k = 0; k < object.karta.palki.size(); k++) {
                        Palka palka = object.karta.palki.get(k);
                        if (CollisionUtils.isPersAndPalkaIntersected(enemy, palka, map, false)) {
                            isUdarilsya = true;
                            break;
                        }
                    }
                }

                // для каждой палки с карты (map.karta)
                //берём палку
                //проверяем, что враг пересекается с палкой
                //если пересекается то ваыставляем, что он ударился и заканчиваем проверку

                for (int i = 0; i < map.getKarta().palki.size(); i++) {
                    Palka palka = map.getKarta().palki.get(i);
                    if (CollisionUtils.isPersAndPalkaIntersected(enemy, palka, map, false)) {
                        isUdarilsya = true;
                        break;
                    }
                }

                if (isUdarilsya) {
                    sign = -sign;
                }

                enemy.setLocation(x, y + 12 * sign);
            }
        });
        timer.start();

        Enemy enemy2 = new Enemy(1700, 2500, 100, 100);
        map.add(enemy2);
        Enemy enemy3 = new Enemy(1800, 2500, 100, 100);
        map.add(enemy3);
    }
}
