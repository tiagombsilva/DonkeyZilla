package org.academiadecodigo.codezillas.Movement;

import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardListener implements KeyboardHandler {

    private Movable movable;

    public KeyboardListener(Movable movable) {

        this.movable = movable;

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent space = new KeyboardEvent();
        KeyboardEvent spaceRelease = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spaceRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        spaceRelease.setKey(32);
        keyboard.addEventListener(space);
        keyboard.addEventListener(spaceRelease);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        movable.translate(0, 10);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        movable.translate(0,-10);
    }

}
