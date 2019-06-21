
package org.academiadecodigo.codezillas;

import org.academiadecodigo.codezillas.gameObjects.Platform;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DonkeyZilla {

    public static void main(String[] args) {

        Platform[] platforms;

       Canvas canvas = new Canvas();
       canvas.init();

        Picture background = new Picture(0,0,"resources/Background.png");
        background.draw();

        platforms = new Platform[30];

        for (int i = 0; i<platforms.length;i++) {
            platforms[i] = new Platform(i,20);
            platforms[i].draw();
        }

    }

}