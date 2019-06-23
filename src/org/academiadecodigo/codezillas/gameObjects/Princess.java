package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Princess extends Picture {


    private Position pos;
    private Picture princess;


    public Princess(int col, int row) {
        pos = new Position(col,row);
        princess = new Picture(pos.colToX(), pos.rowToY(), "resources/Princess.png");
    }

    public void setPos(int x, int y) {
        pos.setCol(x);
        pos.setRow(y);
    }


    public Position getPos() {
        return pos;
    }

    public Rectangle bounds(){
        return new Rectangle(pos.colToX(), pos.rowToY(), 40,40);
    }

    @Override
    public void draw() {
        super.draw();
        princess.draw();
    }


}
