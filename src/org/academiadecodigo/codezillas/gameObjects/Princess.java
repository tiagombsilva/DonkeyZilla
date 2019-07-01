package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.codezillas.AssetPaths;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Princess{

    private Position pos;
    private Picture princess;

    public Princess(int col, int row) {
        pos = new Position(col,row);
        princess = new Picture(pos.colToX(), pos.rowToY(), AssetPaths.PRINCESS);
    }

    Rectangle bounds(){
        return new Rectangle(pos.colToX(), pos.rowToY(), 40,40);
    }

    public void draw() {
        princess.draw();
    }

    public void delete(){
        princess.delete();
    }
}
