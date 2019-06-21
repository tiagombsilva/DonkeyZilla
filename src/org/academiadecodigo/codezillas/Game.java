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

        LevelFactory.level1();

    }

}
