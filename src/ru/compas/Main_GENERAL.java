package ru.compas;

import ru.compas.Messager.Dialog;
import ru.compas.Messager.Message;
import ru.compas.backpack.Backpack;
import ru.compas.things.Artefact;
import ru.compas.collision.CollisionKarta;
import ru.compas.collision.Palka;
import ru.compas.collision.Point;
import ru.compas.things.ArtefactContloller;
import ru.compas.things.CounterController;

///>>>>>>> origin/coin
import javax.swing.*;
import java.util.ArrayList;

public class Main_GENERAL {
    static JFrame frame;

    public static void main(String[] args) {

        frame = Combo_General.creatOkno();
        Combo_General.pane = Combo_General.pane_made(frame);

        Combo_General.list_players = new ArrayList<>();
        player player = Combo_General.player_make(new ImageIcon("pers.png"), 300, 300, "I");
        Combo_General.list_players.add(player);

        MapLocation map = Combo_General.creatMap(-2000, -2000, ("Правая нижняя часть карты 2.png"), frame);
        ArrayList<MapLocation> maps = new ArrayList<>();
        maps.add(map);

        Combo_General.maps = maps;

        controller controller = new controller(frame, player, maps);
        frame.setVisible(true);
    }
}

