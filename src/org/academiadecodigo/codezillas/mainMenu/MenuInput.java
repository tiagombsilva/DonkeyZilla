package org.academiadecodigo.codezillas.mainMenu;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MenuInput {

    public MenuInput(KeyboardHandler menuLogic){

        Keyboard keyboard = new Keyboard(menuLogic);

        KeyboardEvent space = new KeyboardEvent();
        KeyboardEvent leave = new KeyboardEvent();

        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leave.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        space.setKey(KeyboardEvent.KEY_SPACE);
        leave.setKey(KeyboardEvent.KEY_L);

        keyboard.addEventListener(space);
        keyboard.addEventListener(leave);
    }
}
