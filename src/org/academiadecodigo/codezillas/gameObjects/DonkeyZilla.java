package org.academiadecodigo.codezillas.gameObjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class DonkeyZilla extends Picture {

    private Position pos;
    private Picture donkeyZilla;

    public DonkeyZilla(int col, int row) {
        pos = new Position(col,row);
        donkeyZilla = new Picture(pos.colToX(), pos.rowToY(), "resources/GodzillaL.png");

    }

    public void setPos(int x, int y) {
        pos.setCol(x);
        pos.setRow(y);
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


    public Position getPos() {
        return pos;
    }


    @Override
    public void draw() {
        super.draw();
        donkeyZilla.draw();
    }

    public void moveRight() {
        if(pos.getCol()>=29){
            return;
        }
        pos.setCol(pos.getCol() + 1);
        donkeyZilla.load("resources/GodzillaR.png");
        donkeyZilla.translate(40, 0);
    }

    public void moveLeft() {
        if(pos.getCol() <= 10){
            return;
        }
        pos.setCol(pos.getCol() - 1);
        donkeyZilla.load("resources/GodzillaL.png");
        donkeyZilla.translate(- 40,0);
    }

    public Rectangle bounds(){
        return new Rectangle(pos.colToX(), pos.rowToY(), 80,40);
    }

}
