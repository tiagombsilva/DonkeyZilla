package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.codezillas.AssetPaths;
import org.academiadecodigo.codezillas.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Platform {

    private Position pos;
    private Picture platform;

    public Platform(int col, int row){
        pos = new Position(col,row);
        platform = new Picture(pos.colToX(),pos.rowToY(), AssetPaths.STAGE_PLATFORM);
    }

    public void draw(){
        platform.draw();
    }

    Rectangle bounds(){
        return new Rectangle(this.pos.colToX(),this.pos.rowToY(), Canvas.CELL_SIZE, Canvas.CELL_SIZE);
    }
}
