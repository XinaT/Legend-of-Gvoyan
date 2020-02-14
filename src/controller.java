import ru.compas.character;
import ru.compas.player;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class controller {
    String direction = " ";


    controller(JFrame frame, player player) {
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_UP) {

                    player.move("forward");
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    player.move("toward");
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.move("left");
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.move("right");
                }
            }
        });

    }
}
