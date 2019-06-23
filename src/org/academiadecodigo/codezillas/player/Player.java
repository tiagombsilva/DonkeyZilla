package org.academiadecodigo.codezillas.player;

import org.academiadecodigo.codezillas.gameObjects.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Player {

    private int lives;
    private Position pos;
    private Picture princess;
    private boolean isFalling = true;
    public Rectangle hitbox;

    public Player(int col, int row) {
        pos = new Position(col, row);
        hitbox = new Rectangle(col,row,col+40,row+40);
        princess = new Picture(pos.colToX(), pos.rowToY(), "resources/Princess.png");
    }

    public boolean isFalling() {
        return isFalling;
    }

    public void setFalling(boolean fly) {
        isFalling = fly;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(int x, int y) {
        pos.setCol(x);
        pos.setRow(y);
    }

    public Picture getPrincess() {
        return princess;
    }

    public void draw() {
        princess.draw();
    }

    public void playerFall() {
        hitbox.x = princess.getX();
        hitbox.y = princess.getY();

        if (isFalling) {
            pos.setRow(pos.getRow() + 1);
            princess.translate(0, 40);
        }
    }


    public void jump() {

    }

    public void moveRight() {
        pos.setCol(pos.getCol() + 1);
        //princess.load("resources/GodzillaRightDirection.png");
        princess.translate(40, 0);
    }

    public void moveLeft() {
        pos.setCol(pos.getCol() - 1);
        //princess.load("resources/GodzillaRightDirection.png");
        princess.translate(-40, 0);
    }

    public void endLevel() {

    }

    public void loseLife() {
        //perder uma vida e reset position
    }

    public void die() {
        //GAME OVER
    }

    public boolean isTouching() {

        System.out.println("X" + getPos().getCol() + " Y" + getPos().getRow());

        if(getPos().getCol() < 14 || getPos().getCol() > 17){
            if(getPos().getRow() > 2){
                return true;
            }
        }

        if(getPos().getCol() > 0 ){
            if(getPos().getRow() > 4){
                return true;
            }
        }
        return false;
    }
}
