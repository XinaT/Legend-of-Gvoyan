package ru.compas.Enemy;

import ru.compas.MapLocation;
import ru.compas.collision.CollisionObject;
import ru.compas.collision.CollisionUtils;
import ru.compas.collision.Palka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnemyController {
    public static void createEnemies(MapLocation map) {

        Enemy enemy1 = new Enemy(1500, 2200);
        map.add(enemy1);
        setEnemyMovement(enemy1, map);

        Enemy enemy2 = new Enemy(1700, 2200);
        map.add(enemy2);
        setEnemyMovement(enemy2, map);

        Enemy enemy3 = new Enemy(1800, 2200);
        map.add(enemy3);
        setEnemyMovement(enemy3, map);
    }
    static void setEnemyMovement(Enemy enemy, MapLocation map) {
        Timer timer = new Timer(30,null);
        timer.addActionListener(new ActionListener() {

            int sign = 1;

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int x = enemy.getX();
                int y = enemy.getY();

                boolean isUdarilsya = false;
                for (int i = 0; i < map.collisionObjects.size(); i++) {
                    CollisionObject object = map.collisionObjects.get(i);
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

                for (int i = 0; i < map.karta.palki.size(); i++) {
                    Palka palka = map.karta.palki.get(i);
                    if (CollisionUtils.isPersAndPalkaIntersected(enemy, palka, map, false)){
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
    }
}
