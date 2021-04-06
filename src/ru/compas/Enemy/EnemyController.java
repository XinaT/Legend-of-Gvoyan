package ru.compas.Enemy;

import ru.compas.MapLocation;
import ru.compas.collision.CollisionObject;
import ru.compas.collision.CollisionUtils;
import ru.compas.collision.Palka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnemyController extends JLabel {
    public static void createEnemies(MapLocation map) {
        Enemy enemy1 = new Enemy(1500, 2100,100,100);
        map.add(enemy1);

        Timer timer = new Timer(30,null);
        timer.addActionListener(new ActionListener() {

            int sign = 1;

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int x = enemy1.getX();
                int y = enemy1.getY();

                boolean isUdarilsya = false;
                for (int i = 0; i < map.getCollisionObjects().size(); i++) {
                    CollisionObject object = map.getCollisionObjects().get(i);
                    for (int k = 0; k < object.karta.palki.size(); k++) {
                        Palka palka = object.karta.palki.get(k);
                        if (CollisionUtils.isPersAndPalkaIntersected(enemy1, palka, map)) {
                            isUdarilsya = true;
                            break;
                        }
                    }
                }

                if (isUdarilsya) {
                    sign = -sign;
                }

                enemy1.setLocation(x, y + 15 * sign);
            }
        });
        timer.start();

        Enemy enemy2 = new Enemy(1700, 2500,100,100);
        map.add(enemy2);
        Enemy enemy3 = new Enemy(1800, 2500,100,100);
        map.add(enemy3);
    }
}
