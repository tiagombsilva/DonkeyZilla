package org.academiadecodigo.codezillas;

import org.academiadecodigo.codezillas.gameObjects.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private static int levelCounter = 1;

    public static void main(String[] args) {

        Platform[] platforms = null;
        Picture background;
        Player player;
        DonkeyZilla enemy;
        Projectile[] projectiles = null;
        CollisionDetector collisionDetector;

        if (levelCounter == 1) {

            Object[] gameObjects = LevelFactory.level1();
            for (Object object : gameObjects) {
                if (object instanceof Picture) {
                    background = (Picture) object;
                }

                if (object instanceof Platform[]) {
                    platforms = (Platform[]) object;
                }

                if (object instanceof DonkeyZilla) {
                    enemy = (DonkeyZilla) object;
                }

                if (object instanceof Projectile[]) {
                    projectiles = (Projectile[]) object;
                }

                if (object instanceof Player) {
                    player = (Player) object;
                }
            }

            while (true) {
                projectiles[0].setMoving();
                int rng = (int) (Math.random() * projectiles.length + 1);

                for (int i = 0; i < projectiles.length-1; i++) {
                    projectiles[i].fallingDown();

                    if (projectiles[i].isMoving() && projectiles[i].isMiddleScreenPosition()) {
                        projectiles[i+1].setMoving();
                    }
                }







                try {
                    Thread.sleep(70);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                ////PROJECTILE TESTS

            /*projectiles = new Projectile[15];
            int positionPlacer = 0;

            for (int i = 0; i < projectiles.length; i++) {

                projectiles[i] = new Projectile(i + positionPlacer, 0);
                projectiles[i].draw();
                positionPlacer += 1;
            }

            while (true) {

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
                    projectiles[0].draw();*/
                // }

                //}
            }


        }
    }
}
