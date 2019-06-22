package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.codezillas.Game;
import org.academiadecodigo.codezillas.player.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CollisionDetector {

    static Platform[] platforms = null;
    static Picture background;
    static Player player;
    static DonkeyZilla enemy;
    static Projectile[] projectiles = null;


    public CollisionDetector(Object[] object){
        init(object);
    }

    private static void init(Object[] object){

        for (Object objects: object) {
            if (objects instanceof Picture) {
                background = (Picture) objects;
            }

            if (objects instanceof Platform[]) {
                platforms = (Platform[]) objects;
            }

            if (objects instanceof DonkeyZilla) {
                enemy = (DonkeyZilla) objects;
            }

            if (objects instanceof Projectile[]) {
                projectiles = (Projectile[]) objects;
            }

            if (objects instanceof Player) {
                player = (Player) objects;
            }
        }
    }

    public void detectorPlatform(){


    }


}
