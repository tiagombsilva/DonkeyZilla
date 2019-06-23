package org.academiadecodigo.codezillas.mainMenu;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MainMenu {

    private boolean isMenu = true;
    private Picture background = new Picture(0,0,"resources/Menu0.png");

    public void menuLoop(){
        MenuLogic menuLogic = new MenuLogic(this);
        background.draw();
        while(isMenu){
            background.load("resources/Menu0.png");

            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            background.load("resources/Menu1.png");
        }
        background.delete();
    }

    public void setMenu(boolean menu) {
        isMenu = menu;
    }
}
