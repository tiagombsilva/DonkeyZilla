package org.academiadecodigo.codezillas;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

class MainMenu {

    private boolean menu = true;
    private Picture background = new Picture(0,0, AssetPaths.MENU_0);
    private MenuInput menuInput = new MenuInput(new MenuLogic(this));

    void menuLoop(){
        background.draw();
        while(menu){
            background.load(AssetPaths.MENU_1);

            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            background.load(AssetPaths.MENU_0);
        }
        background.delete();
    }

    private void setMenu(boolean menu) {
        this.menu = menu;
    }

    private class MenuInput{
        MenuInput(KeyboardHandler menuLogic){

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

    private class MenuLogic implements KeyboardHandler {

        private MainMenu menu;
        MenuLogic(MainMenu menu){
            this.menu = menu;
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
}
