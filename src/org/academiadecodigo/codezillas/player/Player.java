package org.academiadecodigo.codezillas.player;

import org.academiadecodigo.codezillas.gameObjects.Position;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player{

    private int lives;
    private Position pos;
    private Picture princess;
    private boolean isFalling = true;

    public Player (int col, int row){
        pos = new Position(col, row);
        princess = new Picture(pos.colToX(), pos.rowToY(), "resources/Princess.png");
    }

    public boolean isFalling() {
        return isFalling;
    }

    public Position getPos(){
        return pos;
    }

    public Picture getPrincess(){
        return princess;
    }

    public void draw(){
        princess.draw();
    }

    public void playerFall(){
        pos.setRow(pos.getRow()+20);
        princess.translate(0,20);
    }


    public void jump() {

    }

    public void moveRight() {
        pos.setCol(pos.getCol() + 8);
        //princess.load("resources/GodzillaRightDirection.png");
        princess.translate(8, 0);
    }

    public void moveLeft(){
        pos.setCol(pos.getCol() - 8);
        //princess.load("resources/GodzillaRightDirection.png");
        princess.translate(-8, 0);
    }

    public void endLevel() {

    }

    public void loseLife() {
        //perder uma vida e reset position
    }

    public void die() {
        //GAME OVER
    }

}
