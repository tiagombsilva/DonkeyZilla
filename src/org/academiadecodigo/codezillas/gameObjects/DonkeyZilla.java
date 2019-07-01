package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.codezillas.AssetPaths;
import org.academiadecodigo.codezillas.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class DonkeyZilla{

    private Position pos;
    private Picture donkeyZilla;

    public DonkeyZilla(int col, int row) {
        pos = new Position(col,row);
        donkeyZilla = new Picture(pos.colToX(), pos.rowToY(),AssetPaths.DONKEYZILLA_LEFT);
    }

    public void move(){
        int prob = (int) Math.floor(Math.random()*2);

        if(prob == 0){
            moveRight();
        }

        if(prob == 1){
            moveLeft();
        }
    }

    public void delete(){
        donkeyZilla.delete();
    }

    public void draw() {
        donkeyZilla.draw();
    }

    private void moveRight() {
        if(pos.getCol()>=29){
            return;
        }
        pos.setCol(pos.getCol() + 1);
        donkeyZilla.load(AssetPaths.DONKEYZILLA_RIGHT);
        donkeyZilla.translate(Canvas.CELL_SIZE, 0);
    }

    private void moveLeft() {
        if(pos.getCol() <= 10){
            return;
        }
        pos.setCol(pos.getCol() - 1);
        donkeyZilla.load(AssetPaths.DONKEYZILLA_LEFT);
        donkeyZilla.translate(- Canvas.CELL_SIZE,0);
    }

    Rectangle bounds(){
        return new Rectangle(pos.colToX(), pos.rowToY(), Canvas.CELL_SIZE*2, Canvas.CELL_SIZE);
    }

}
