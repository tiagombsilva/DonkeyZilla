package org.academiadecodigo.codezillas.player;

import org.academiadecodigo.codezillas.gameObjects.CollisionDetector;
import org.academiadecodigo.codezillas.gameObjects.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Player {

    private int lives;
    private Position pos;
    private Picture guy;
    private boolean isFalling = true;
    private boolean isJumping;
    private int jumpCounter;

    public Player(int col, int row) {
        pos = new Position(col, row);
        guy = new Picture(pos.colToX(), pos.rowToY(), "resources/PlayerRight.png");
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

    public Picture getGuy() {
        return guy;
    }

    public void draw() {
        guy.draw();
    }

    public void playerFall() {
        pos.setRow(pos.getRow() + 1);
        guy.translate(0, 40);
    }


    public void jump() {

        while(jumpCounter < 4) {
            if (CollisionDetector.detect(this.topBounds())) {
                setFalling(true);
                jumpCounter = 0;
                return;
            }
            if(pos.rowToY()-40 == 0){
                return;
            }
            jumpCounter++;
            pos.setRow(pos.getRow() - 1);
            guy.translate(0, -40);

        }
        setFalling(true);
        jumpCounter = 0;

    }


    public void moveRight() {
        if (this.getPos().getCol() == 29) {
            return;
        }
        if (CollisionDetector.detect(this.rightBounds())){
            return;
        }
        pos.setCol(pos.getCol() + 1);
        guy.load("resources/PlayerRight.png");
        guy.translate(40, 0);
    }

    public void moveLeft() {
        if (this.getPos().getCol() == 0){
            return;
        }

        if (CollisionDetector.detect(this.leftBounds())){
            return;
        }

        pos.setCol(pos.getCol() - 1);
        guy.load("resources/PlayerLeft.png");
        guy.translate(-40, 0);
    }

    public void playerMove() {
        if (CollisionDetector.detect(this.bottomBounds())) {
            setFalling(false);
            return;
        }else{
            setFalling(true);
        }

        if (isFalling) {
            this.playerFall();
        }
        if (isJumping) {
            this.jump();
        }

    }

    public void endLevel() {

    }

    public void loseLife() {
        //perder uma vida e reset position
    }

    public void die() {
        //GAME OVER
    }

    public Rectangle bottomBounds() {
        return new Rectangle(this.pos.colToX(), this.pos.rowToY() + 40, 40, 40);
    }

    public Rectangle topBounds() {
        return new Rectangle(this.pos.colToX(), this.pos.rowToY() - 40, 40, 40);
    }

    public Rectangle leftBounds() {
        return new Rectangle(this.pos.colToX() - 40, this.pos.rowToY(), 40, 40);
    }

    public Rectangle rightBounds() {
        return new Rectangle(this.pos.colToX() + 40, this.pos.rowToY(), 40, 40);
    }

}
