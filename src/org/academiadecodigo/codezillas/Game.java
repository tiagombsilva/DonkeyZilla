package org.academiadecodigo.codezillas;

import org.academiadecodigo.codezillas.gameObjects.*;
import org.academiadecodigo.codezillas.gameObjects.factory.PlatformFactory;
import org.academiadecodigo.codezillas.gameObjects.factory.ProjectileFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private int levelCounter = 0;
    private Picture background;
    private Player player;
    private DonkeyZilla enemy;
    private Princess princess;
    private Projectile[] projectiles;
    private Platform[][] platforms;
    private boolean gameOver;
    private GameMusic GameMusic = new GameMusic();

    public static void main(String[] args) {
        Game game = new Game();
        Canvas canvas = new Canvas();
        game.start();
    }

    private void start() {
        setupLevel();

        while (levelCounter > 0 || gameOver) {
            if (player.isDead()) {
                endGame();
                break;
            }

            if (CollisionDetector.intersectsEnemy()) {
                GameMusic.stopMusic();
                gameOver = true;
                endGame();
                break;
            }

            if (CollisionDetector.intersectsPrincess()) {
                GameMusic.stopMusic();
                gameOver = true;
                win();
                return;
            }

            shootProjectiles();
            player.playerMove();
            enemy.move();
            CollisionDetector.intersectsProjectile();

            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        levelCounter++;
        start();
    }

    private void setupLevel() {
        switch (levelCounter) {
            case 0:
                setupMenu();
                break;
            case 1:
                setupStage();
                setupCollisionDetector();
                renderStage();
                break;
            default:
                throw new UnsupportedOperationException("Invalid levelCounter value");
        }
    }


    private void shootProjectiles() {
        for (int i = 0; i < projectiles.length - 1; i++) {
            projectiles[i].fallingDown();
            if (projectiles[i].isMoving() && projectiles[i].isMiddleScreen()) {
                projectiles[i + 1].setMoving();
            }
        }
    }


    private void setupCollisionDetector() {
        CollisionDetector.setPlatforms(platforms);
        CollisionDetector.setPlayer(player);
        CollisionDetector.setProjectiles(projectiles);
        CollisionDetector.setEnemy(enemy);
        CollisionDetector.setPrincess(princess);
    }

    private void renderStage() {
        background.draw();

        for (Platform[] arr : platforms) {
            for (Platform platform : arr) {
                if (platform != null) {
                    platform.draw();
                }
            }
        }

        princess.draw();
        player.draw();
        enemy.draw();
        projectiles[0].setMoving();
    }

    private void setupStage() {
        princess = new Princess(2, 3);
        player = new Player(4, 1);
        enemy = new DonkeyZilla(25, 6);
        background = new Picture(0, 0, AssetPaths.STAGE_BACKGROUND);
        projectiles = ProjectileFactory.createProjectiles();
        platforms = PlatformFactory.createPlatforms();
    }

    private void setupMenu() {
        MainMenu menu = new MainMenu();
        GameMusic.play(AssetPaths.MENU_MUSIC);
        menu.menuLoop();
        GameMusic.stopMusic();
        GameMusic.play(AssetPaths.GAME_MUSIC);
    }

    private void endGame() {
        showGameOver();

        gameOverAnimation();

        resetGameOverState();
    }

    private void resetGameOverState() {
        gameOver = false;
        levelCounter = -1;
        background.delete();
    }

    private void win() {
        showStageCleared();

        showStageClearedAnimation();

        showCredits();

        System.exit(0);
    }

    private void showCredits() {
        for (int i = 0; i < 10; i++) {
            background.load(AssetPaths.CREDITS_SCREEN_1);

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            background.load(AssetPaths.CREDITS_SCREEN_2);
        }
    }

    private void showStageClearedAnimation() {
        String[] screens = {
                AssetPaths.WIN_SCREEN_1,
                AssetPaths.WIN_SCREEN_2,
                AssetPaths.WIN_SCREEN_3
        };

        for (String screen : screens) {
            background.load(screen);
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void showStageCleared() {
        GameMusic.play(AssetPaths.CREDITS_MUSIC);

        player.getPlayerImage().delete();
        princess.delete();
        enemy.delete();

        background.delete();
        background.draw();
        background.load(AssetPaths.CREDITS_SCREEN_1);
    }

    private void showGameOver() {
        gameOver = true;

        GameMusic.stopMusic();
        GameMusic.play(AssetPaths.GAME_OVER_MUSIC);

        player.getPlayerImage().delete();
        princess.delete();
        enemy.delete();

        background.delete();
        background.draw();
        background.load(AssetPaths.GAME_OVER_SCREEN_1);
    }

    private void gameOverAnimation() {

        for (int i = 0; i < 10; i++) {
            background.load(AssetPaths.GAME_OVER_SCREEN_1);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            background.load(AssetPaths.GAME_OVER_SCREEN_2);
        }
        GameMusic.stopMusic();
        background.delete();
    }
}
