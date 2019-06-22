package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.codezillas.player.MovementLogic;
import org.academiadecodigo.codezillas.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class LevelFactory {

    private static Object[] gameObject = new Object[10];

    public static Object[] level1() {

        Player player = new Player(1, 2);
        MovementLogic movementLogic = new MovementLogic(player);
        Platform[] platforms = new Platform[150];
        Picture background;
        DonkeyZilla donkeyZilla;
        Projectile[] projectiles = new Projectile[10];
        donkeyZilla = new DonkeyZilla(10, 6);
        background = new Picture(0, 0, "resources/Background.png");
        background.draw();


        for (int i = 4; i < 20; i += 3) {
            for (int y = 0; y < 30; y++) {
                platforms[y] = new Platform(y, i);
                platforms[y].draw();
/**
 try {
 Thread.sleep(25);
 } catch (Exception e){

 }
 **/

                if (i == 4) {
                    if ((y == 15) || (y == 16)) {
                        platforms[y].delete();
                        continue;
                    }
                }

                if (i == 7) {
                    if ((y == 0) || (y == 1)) {
                        platforms[y].delete();
                        continue;
                    }
                }

                if (i == 10) {
                    if ((y == 18) || (y == 19)) {
                        platforms[y].delete();
                        continue;
                    }
                }

                if (i == 13) {
                    if ((y == 2) || (y == 3)) {
                        platforms[y].delete();
                        continue;
                    }
                }

                if (i == 16) {
                    if ((y == 16) || (y == 17)) {
                        platforms[y].delete();
                        continue;
                    }
                }
            }
        }


        //Projectile Spawn Logic
        for (int i = 0; i < projectiles.length; i++) {
            int randomCol = (int) (Math.random() * 30);
            projectiles[i] = new Projectile(randomCol, -1);
            projectiles[i].draw();
        }
        projectiles[0].setMoving();
        ///////

        donkeyZilla.draw();
        player.draw();

        gameObject[0] = background;
        gameObject[1] = platforms;
        gameObject[2] = donkeyZilla;
        gameObject[3] = projectiles;
        gameObject[4] = movementLogic;
        gameObject[5] = player;
        return gameObject;

    }

}