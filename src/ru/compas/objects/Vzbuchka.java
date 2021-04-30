package ru.compas.objects;

import ru.compas.Combo_General;
import ru.compas.Enemy.Enemy;
import ru.compas.things.CounterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Vzbuchka extends JLabel {
    public int life_enemy;
    public int life_pers;
    public int strong_enemy;
    public int strong_pers;
    public Timer timer;
    public JLabel indikator_player;
    public  JLabel indikator_enemy;
    public Enemy enemy;

    public Vzbuchka(int x, int y, int Life_enemy, int Strong_enemy, int Life_pers, int Strong_pers, Enemy enemik) {
        setLocation(x, y);
        setSize(100, 100);
        setOpaque(false);
        setVisible(true);
        setIcon(new ImageIcon("tenor-unscreen.gif"));

        life_enemy = Life_enemy;
        life_pers = Life_pers;
        strong_enemy = Strong_enemy;
        strong_pers  = Strong_pers;
        enemy = enemik;

        JLabel indik_player = Combo_General.LabelMake(x, y-15,  life_pers, 10, new Font("Arial", 0, 15), "");
        indik_player.setBackground(Color.red);
        Combo_General.pane.add(indik_player);
        Combo_General.pane.setLayer(indik_player, 5);
        indikator_player = indik_player;

        JLabel indik_enemy = Combo_General.LabelMake(x, y-30, life_enemy, 10,  new Font("Arial", 0, 15), "");
        indik_enemy.setBackground(Color.blue);
        Combo_General.pane.add(indik_enemy);
        Combo_General.pane.setLayer(indik_enemy, 5);
        indikator_enemy = indik_enemy;

        Combo_General.pane.repaint();

        Timer timer1 = new Timer(80, null);
        timer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                life_pers = life_pers - strong_enemy;
                life_enemy = life_enemy - strong_pers;

                indikator_player.setSize(life_pers, indikator_player.getHeight());
                indikator_enemy.setSize(life_enemy, indikator_enemy.getHeight());
                CounterController.set_life_indikator();

                if (life_enemy<=0){
                    System.out.println("ПОБЕДА");
                    end_vzbuchka();
                }else if(life_pers <=0){
                    System.out.println("ВЫ ПРОИГРАЛИ");
                    end_vzbuchka();
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
        Combo_General.pane.remove(Vzbuchka.this);
        Combo_General.pane.remove(indikator_enemy);
        Combo_General.pane.remove(indikator_player);
        Combo_General.list_players.get(0).setVisible(true);
        Combo_General.list_players.get(0).hp = life_pers;
        enemy.life = life_enemy;
        Combo_General.pane.repaint();
    }
}
