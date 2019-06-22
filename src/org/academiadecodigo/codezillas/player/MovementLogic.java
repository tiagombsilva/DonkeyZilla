package org.academiadecodigo.codezillas.player;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MovementLogic implements KeyboardHandler {

    private Player player;

    public MovementLogic(Player player) {

        this.player = player;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            player.moveLeft();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            player.moveRight();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            player.jump();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
