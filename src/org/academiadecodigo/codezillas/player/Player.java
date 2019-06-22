package org.academiadecodigo.codezillas.player;

import org.academiadecodigo.codezillas.gameObjects.Position;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements KeyboardHandler {

    private int lives;
    private Position pos;
    private Picture princess;
    private boolean falling;

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

    public void moveRight() {

    }

    public void moveLeft(){

    }

    public void endLevel() {

    }

    public void loseLife() {
        //perder uma vida e reset position
    }

    public void die() {
        //GAME OVER
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {

            this.moveLeft();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
