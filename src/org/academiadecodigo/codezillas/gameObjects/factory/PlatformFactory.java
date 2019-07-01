package org.academiadecodigo.codezillas.gameObjects.factory;

import org.academiadecodigo.codezillas.gameObjects.Platform;

public class PlatformFactory {

    public static Platform[][] createPlatforms() {
        Platform[][] platforms = new Platform[20][30];

        for (int i = 0; i < 20; i++) {
            for (int y = 0; y < 30; y++) {
                if (i == 4 || i == 7 || i == 10 || i == 13 || i == 16 || i == 19) {
                    platforms[i][y] = new Platform(y, i);
                }

                if (i == 4 && (y == 15 || y == 16)) {
                    platforms[i][y] = null;
                    continue;
                }

                if (i == 7 && (y == 0 || y == 1)) {
                    platforms[i][y] = null;
                    continue;
                }

                if (i == 10 && (y == 18 || y == 19)) {
                    platforms[i][y] = null;
                    continue;
                }

                if (i == 13 && (y == 2 || y == 3)) {
                    platforms[i][y] = null;
                    continue;
                }

                if (i == 16 && (y == 16 || y == 17)) {
                    platforms[i][y] = null;
                }
            }
        }
        return platforms;
    }
}
