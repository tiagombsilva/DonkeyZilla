package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {


    private int lives;
    private Position pos;
    private Picture princess;

    public Player (int col, int row){
        pos = new Position(col, row);
        princess = new Picture(pos.colToX(), pos.rowToY(), "resources/Princess.png");
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


    public void jump() {

    }

    public void move() {

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
