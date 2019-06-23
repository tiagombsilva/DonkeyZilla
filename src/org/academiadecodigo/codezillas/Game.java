package org.academiadecodigo.codezillas;

import org.academiadecodigo.codezillas.gameObjects.*;
import org.academiadecodigo.codezillas.mainMenu.MainMenu;
import org.academiadecodigo.codezillas.music.*;
import org.academiadecodigo.codezillas.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private static int levelCounter = 0;

    private static Platform[][] platforms = null;
    private static Picture background;
    private static Player player = null;
    private static DonkeyZilla enemy;
    private static Princess princess;
    private static Projectile[] projectiles = null;
    private static CollisionDetector collisionDetector;
    private static MainMenu menu;
    private static boolean gameOver = false;
    private static GameMusic gameMusic = new GameMusic();
    private static MenuMusic menuMusic = new MenuMusic();
    private static GameOverMusic gameOverMusic = new GameOverMusic();
    private static WinMusic winMusic = new WinMusic();
    private static CreditsMusic creditsMusic = new CreditsMusic();

    public static void main(String[] args) {

        initGame(levelCounter);

        while (levelCounter > 0 || gameOver) {

            if (player.isDead()) {
                gameOver();
            }
            if(touchPrincess()){
                gameOver = true;
                return;
            }

            shootprojectiles();
            player.playerMove();
            enemy.move();
            hitable();

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

    public static void hitable() {
        for (int i = 0; i < projectiles.length - 1; i++) {
            if (player.Bounds().intersects(projectiles[i].bounds())) {
                player.die();
                System.out.println("top");
            }
            if (player.Bounds().intersects(projectiles[i].bounds())) {
                player.die();
                System.out.println("left");
            }
            if (player.Bounds().intersects(projectiles[i].bounds())) {
                player.die();
                System.out.println("right");
            }
            if (player.Bounds().intersects(projectiles[i].bounds())) {
                player.die();
                System.out.println("bottom");
            }
        }
    }

    public static boolean touchPrincess() {
        if (player.Bounds().intersects(princess.bounds())) {
            return true;
        }
        return false;
    }

    public static boolean touchDonkeyzilla() {
        if (player.Bounds().intersects(enemy.bounds())) {
            player.die();
        }
        return false;
    }


    public static void initGame(int lvl) {
        if (levelCounter == 0) {
            menu = (MainMenu) LevelFactory.menu();
            menuMusic.startMenuMusic();
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
                if (object instanceof Princess) {
                    princess = (Princess) object;
                }
            }
        }
    }

    public static void gameOver(){
        player.getGuy().delete();
        princess.delete();
        enemy.delete();
        background.draw();

        int count = 0;

        while(count < 30) {
            background.load("resources/GameOver.jpg");
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            background.load("resources/GameOverLast.jpg");
            count++;
            System.out.println(count);
        }
        System.exit(0);
    }

    public static void win(){

    }

}