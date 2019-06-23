package org.academiadecodigo.codezillas;

import org.academiadecodigo.codezillas.gameObjects.*;
import org.academiadecodigo.codezillas.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private static int levelCounter = 1;

    public static void main(String[] args) {

        Platform[][] platforms = null;
        Picture background;
        Player player = null;
        DonkeyZilla enemy;
        Projectile[] projectiles = null;
        CollisionDetector collisionDetector;

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

            while (true) {
                int rng = (int) (Math.random() * projectiles.length + 1);

                for (int i = 0; i < projectiles.length - 1; i++) {
                    projectiles[i].fallingDown();

                    if (projectiles[i].isMoving() && projectiles[i].isMiddleScreenPosition()) {
                        projectiles[i + 1].setMoving();
                    }
                }

                player.playerMove();


                try {
                    Thread.sleep(70);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    ///SOLUÇAO  : 1. Atualizar pos. da Hitbox!! ; 2. Hitbox mexer primeiro que o objeto,
    // e se colidir, volta atras, e o objeto nao se mexe!!
    //player.setFalling(true);
}




