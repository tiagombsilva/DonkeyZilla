package org.academiadecodigo.codezillas;

import org.academiadecodigo.codezillas.gameObjects.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private static int levelCounter = 1;

    public static void main(String[] args) {

        Platform[] platforms;
        Picture background;
        Player player;
        DonkeyZilla enemy;
        Projectile[] projectiles;
        CollisionDetector collisionDetector;

        if(levelCounter == 1) {

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


            ////PROJECTILE TESTS

            projectiles = new Projectile[15];
            int positionPlacer = 0;

            for (int i = 0; i < projectiles.length; i++) {

                projectiles[i] = new Projectile(i + positionPlacer, 0);
                projectiles[i].draw();
                positionPlacer += 1;
            }

            for (int i = 0; i < 10; i++) {

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
        }


    }
}
