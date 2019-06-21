package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class LevelFactory {

    private static Object[] gameObject = new Object[5];

    public static Object[] level1(){

        Platform[] platforms = new Platform[150];
        Picture background;
        DonkeyZilla donkeyZilla;

        donkeyZilla = new DonkeyZilla(10,6);
        background = new Picture(0,0,"resources/Background.png");
        background.draw();

        for(int i = 2; i < 20;i+=3){
            for(int y = 0; y < 30; y++){
                platforms[y] = new Platform(y,i);
                platforms[y].draw();
/**
                try {
                    Thread.sleep(25);
                } catch (Exception e){

                }
**/

                if(i == 2){
                    if((y==15) || (y==16)){
                        platforms[y].delete();
                        continue;
                    }
                }

                if(i == 5){
                    if((y==0) || (y==1)){
                    platforms[y].delete();
                    continue;
                    }
                }

                if(i == 8){
                    if((y==18) || (y==19)){
                        platforms[y].delete();
                        continue;
                    }
                }

                if(i == 11){
                    if((y==2) || (y==3)){
                        platforms[y].delete();
                        continue;
                    }
                }

                if(i == 14){
                    if((y==16) || (y==17)){
                        platforms[y].delete();
                        continue;
                    }
                }
            }
        }

        donkeyZilla.draw();
        gameObject[0] = background;
        gameObject[1] = platforms;
        gameObject[2] = donkeyZilla;
        return gameObject;

    }

}