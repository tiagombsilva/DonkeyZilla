package org.academiadecodigo.codezillas.gameObjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DonkeyZilla extends Picture {

    private Position pos;
    private Picture donkeyZilla;

    public DonkeyZilla(int col, int row) {
        pos = new Position(col,row);
        donkeyZilla = new Picture(pos.colToX(), pos.rowToY(), "resources/GodzillaLeftDirection.png");
    }

    public void setPos(int x, int y) {
        pos.setCol(x);
        pos.setRow(y);
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
        pos.setCol(pos.getCol() + 5);
        donkeyZilla.load("resources/GodZillaRightDirection.png");
        donkeyZilla.translate(5, 0);
    }

    public void moveLeft() {
        pos.setCol(pos.getCol() - 5);
        donkeyZilla.load("resources/GodZillaLeftDirection.png");
        donkeyZilla.translate(- 5,0);
    }

}
