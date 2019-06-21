package org.academiadecodigo.codezillas;

import org.academiadecodigo.codezillas.gameObjects.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    public static void main(String[] args) {

        Platform[] platforms;
        Canvas canvas;
        Player player;
        DonkeyZilla enemy;
        Projectile[] projectiles;
        CollisionDetector collisionDetector;
        


        /////TEST DRIVE

        Picture background = new Picture(0,0,"resources/Background.png");
        background.draw();

        platforms = new Platform[30];

        for (int i= 0; i<platforms.length;i++){

            platforms[i] = new Platform(i,19);
            platforms[i].draw();

        }

        ////PROJECTILE TESTS

        projectiles = new Projectile[15];
        int positionPlacer = 0;

        for (int i = 0; i<projectiles.length; i++) {

            projectiles[i] = new Projectile(i + positionPlacer,0);
            projectiles[i].draw();
            positionPlacer += 1;
        }

        while(true) {

            projectiles[0].fallingDown();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        //platforms[1].getPlatform().delete();




    }

}
