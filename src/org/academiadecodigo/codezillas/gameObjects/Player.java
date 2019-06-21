package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Player implements KeyboardHandler{


    private int lives;
    private Position pos;
    private Picture princess;
    private Keyboard keyboard;

    public Player (int col, int row){
        pos = new Position(col, row);
        princess = new Picture(pos.colToX(), pos.rowToY(), "resources/Princess.png");
        keyboard = new Keyboard(this);
    }

    public void init(){

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
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
