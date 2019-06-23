package org.academiadecodigo.codezillas;

import org.academiadecodigo.codezillas.gameObjects.*;
import org.academiadecodigo.codezillas.mainMenu.MainMenu;
import org.academiadecodigo.codezillas.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private static int levelCounter = 0;

    private static Platform[][] platforms = null;
    private static Picture background;
    private static Player player = null;
    private static DonkeyZilla enemy;
    private static Projectile[] projectiles = null;
    private static CollisionDetector collisionDetector;
    private static MainMenu menu;
    private static boolean gameOver = false;

    public static void main(String[] args) {

        initGame(levelCounter);

        while (levelCounter > 0 || gameOver) {

            shootprojectiles();
            player.playerMove();

            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        levelCounter++;
        main(args);
    }


    public static void shootprojectiles() {
        int rng = (int) (Math.random() * projectiles.length + 1);
        for (int i = 0; i < projectiles.length - 1; i++) {
            projectiles[i].fallingDown();
            if (projectiles[i].isMoving() && projectiles[i].isMiddleScreenPosition()) {
                projectiles[i + 1].setMoving();
            }
        }
    }

    public static void initGame(int lvl) {
        if(levelCounter == 0){
            menu = (MainMenu) LevelFactory.menu();
            menu.menuLoop();
        }

        if (levelCounter == 1) {
            Object[] gameObjects = LevelFactory.level1();
            collisionDetector = new CollisionDetector(gameObjects);

            for (Object object : gameObjects) {
                if (object instanceof Picture) {
                    background = (Picture) object;
                }
                if (object instanceof Platform[][]) {
                    platforms = (Platform[][]) object;
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
        }
    }

}