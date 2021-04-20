package ru.compas.objects;

import ru.compas.collision.CollisionObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Vzbuchka extends JLabel {
    public int life_enemy;
    public int life_pers;
    public int strong_enemy;
    public int strong_pers;
    public Timer timer;

    public Vzbuchka(int x, int y) {
        setLocation(x, y);
        setSize(100, 100);
        setOpaque(false);
        setVisible(true);
        setIcon(new ImageIcon("tenor-unscreen.gif"));

        Timer timer1 = new Timer(50, null);
        timer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int razn = strong_pers-strong_enemy;
                if (razn >0){
                    life_enemy = life_enemy - razn;
                } else {
                    life_pers = life_pers + razn;
                }

                if (life_enemy<=0){
                    System.out.println("ПОБЕДА");
                }
            }
        });
        timer = timer1;
    }

    public void vzbuchka_controller(){
        timer.start();
    }

    public void end_vzbuchka(){
        timer.stop();
    }
}
