package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.codezillas.Canvas;
import org.academiadecodigo.codezillas.Player;

import java.awt.*;

public class CollisionDetector {

    private static Platform[][] platforms;
    private static Projectile[] projectiles;
    private static Player player;
    private static Princess princess;
    private static DonkeyZilla enemy;

    public static void intersectsProjectile() {
        for (int i = 0; i < projectiles.length - 1; i++) {
            if (player.playerBounds().intersects(projectiles[i].bounds())) {
                player.setDead(true);
            }
        }
    }

    public static boolean intersectsPrincess() {
        return player.playerBounds().intersects(princess.bounds());
    }

    public static boolean intersectsEnemy() {
        return player.playerBounds().intersects(enemy.bounds());
    }

    public static boolean intersectsPlatform(int box) {
        Rectangle[] hitBox = {new Rectangle(player.getPos().colToX(),player.getPos().rowToY() + Canvas.CELL_SIZE, Canvas.CELL_SIZE, Canvas.CELL_SIZE),
                new Rectangle(player.getPos().colToX(),player.getPos().rowToY() - Canvas.CELL_SIZE, Canvas.CELL_SIZE, Canvas.CELL_SIZE),
                new Rectangle(player.getPos().colToX() - Canvas.CELL_SIZE,player.getPos().rowToY(), Canvas.CELL_SIZE, Canvas.CELL_SIZE),
                new Rectangle(player.getPos().colToX() + Canvas.CELL_SIZE,player.getPos().rowToY(), Canvas.CELL_SIZE, Canvas.CELL_SIZE),
        };
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 30; x++) {
                Platform platform = platforms[y][x];
                    if (platform != null && hitBox[box].intersects(platform.bounds())) {
                        return true;
                }
            }
        }
        return false;
    }

    public static void setProjectiles(Projectile[] projectiles) {
        CollisionDetector.projectiles = projectiles;
    }

    public static void setPlatforms(Platform[][] platforms) {
        CollisionDetector.platforms = platforms;
    }

    public static void setPlayer(Player player) {
        CollisionDetector.player = player;
    }

    public static void setPrincess(Princess princess) {
        CollisionDetector.princess = princess;
    }

    public static void setEnemy(DonkeyZilla enemy) {
        CollisionDetector.enemy = enemy;
    }
}

