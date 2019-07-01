package org.academiadecodigo.codezillas.gameObjects.factory;

import org.academiadecodigo.codezillas.gameObjects.Projectile;

public class ProjectileFactory {

    public static Projectile[] createProjectiles() {
        Projectile[] projectiles = new Projectile[10];

        for (int i = 0; i < projectiles.length; i++) {
            int randomCol = (int) (Math.random() * 30);
            projectiles[i] = new Projectile(randomCol, -1);
            projectiles[i].draw();
        }
        return projectiles;
    }
}
