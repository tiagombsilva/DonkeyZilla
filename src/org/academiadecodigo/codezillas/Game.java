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
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (projectiles[0].getPos().getRow() == 800) {
                projectiles[0].delete();
                projectiles[0].setPos(0, 0);
                projectiles[0].resetFireball();
                projectiles[0].draw();
            }
        }

        ///END PROJECTILE TESTS






    }

}
