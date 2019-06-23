package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.codezillas.player.MovementLogic;
import org.academiadecodigo.codezillas.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class LevelFactory {

    private static Object[] gameObject = new Object[10];

    public static Object[] level1() {

        Player player = new Player(1, 1);
        MovementLogic movementLogic = new MovementLogic(player);
        Platform[][] platforms = new Platform[20][30];
        Picture background;
        DonkeyZilla donkeyZilla;
        Projectile[] projectiles = new Projectile[10];
        donkeyZilla = new DonkeyZilla(10, 6);
        background = new Picture(0, 0, "resources/Background.png");
        background.draw();

        // LinkedList<Platform> platforms1 = new LinkedList<Platform>();


        for (int i = 0; i < 20; i++) {
            for (int y = 0; y < 30; y++) {

/**
 try {
 Thread.sleep(25);
 } catch (Exception e){

 }
 **/
                if (i == 4 || i == 7 || i == 10 || i == 13 || i == 16 || i == 19) {
                    platforms[i][y] = new Platform(y, i);
                    platforms[i][y].draw();
                }

                if (i == 4 && (y == 15 || y == 16)) {
                    platforms[i][y].delete();
                    platforms[i][y] = null;
                    continue;
                }

                if (i == 7 && (y == 0 || y == 1)) {
                    platforms[i][y].delete();
                    platforms[i][y] = null;
                    continue;
                }

                if (i == 10 && (y == 18 || y == 19)) {
                    platforms[i][y].delete();
                    platforms[i][y] = null;
                    continue;
                }

                if (i == 13 && (y == 2 || y == 3)) {
                    platforms[i][y].delete();
                    platforms[i][y] = null;
                    continue;
                }

                if (i == 16 && (y == 16 || y == 17)) {
                    platforms[i][y].delete();
                    platforms[i][y] = null;
                    continue;
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