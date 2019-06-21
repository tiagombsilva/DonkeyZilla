package org.academiadecodigo.codezillas;

import org.academiadecodigo.codezillas.gameObjects.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    public static void main(String[] args) {

        Platform[] platforms;
        Canvas canvas;
        Player player;
        DonkeyZilla enemy;
        Projectile[] projectile;
        CollisionDetector collisionDetector;
        


        /////TEST DRIVE

        Picture background = new Picture(0,0,"resources/Background.png");
        background.draw();

        platforms = new Platform[30];

        for (int i= 0; i<platforms.length;i++){

            platforms[i] = new Platform(i,19);
            platforms[i].draw();

        }

        //TESTING GODZILLA
        enemy = new DonkeyZilla(10,0);
        enemy.draw();

        //platforms[1].getPlatform().delete();

        //TESTING GODZILLA RIGHT MOVEMENT
        while (true) {
            enemy.moveRight();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
