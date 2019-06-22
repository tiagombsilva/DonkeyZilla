package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.codezillas.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CollisionDetector {

    Platform[] platforms;
    Player player;
    DonkeyZilla enemy;
    Projectile[] projectiles;
    Object[] gameObjects;

    public CollisionDetector(Object[] gameObjects){
        this.gameObjects = gameObjects;
        this.init(gameObjects);
    }

    private void init(Object[] gameObjects){
        for (Object object : gameObjects) {

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



    }



        




}
