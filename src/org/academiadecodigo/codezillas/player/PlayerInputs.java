package org.academiadecodigo.codezillas.player;

import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerInputs implements KeyboardHandler {




    public PlayerInputs(Movable movable) {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent space = new KeyboardEvent();
        KeyboardEvent spaceRelease = new KeyboardEvent();
        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent leftRelease = new KeyboardEvent();
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent rightRelease = new KeyboardEvent();

        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spaceRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        left.setKey(KeyboardEvent.KEY_LEFT);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        space.setKey(KeyboardEvent.KEY_SPACE);

        spaceRelease.setKey(32);
        leftRelease.setKey(37);
        rightRelease.setKey(39);

        keyboard.addEventListener(space);
        keyboard.addEventListener(spaceRelease);
        keyboard.addEventListener(left);
        keyboard.addEventListener(leftRelease);
        keyboard.addEventListener(right);
        keyboard.addEventListener(rightRelease);




    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }




}
