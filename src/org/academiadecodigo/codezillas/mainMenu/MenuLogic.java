package org.academiadecodigo.codezillas.mainMenu;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MenuLogic implements KeyboardHandler {

    private MainMenu menu;
    private MenuInput menuInput;

    public MenuLogic(MainMenu menu){
        this.menu = menu;
        this.menuInput = new MenuInput(this);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
            menu.setMenu(false);
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_L){
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
