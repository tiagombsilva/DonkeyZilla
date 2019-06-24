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
    private boolean isDead;

    public Player(int col, int row) {
        pos = new Position(col, row);
        guy = new Picture(pos.colToX(), pos.rowToY(), "resources/PlayerRight.png");
    }

    public boolean isFalling() {
        return isFalling;
    }

    public boolean isDead(){
        return isDead;
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
            if (CollisionDetector.detect(this.topBoundsPlatform())) {
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
        if (CollisionDetector.detect(this.rightBoundsPlatform())){
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

        if (CollisionDetector.detect(this.leftBoundsPlatform())){
            return;
        }

        pos.setCol(pos.getCol() - 1);
        guy.load("resources/PlayerLeft.png");
        guy.translate(-40, 0);
    }

    public void playerMove() {
        if (CollisionDetector.detect(this.bottomBoundsPlatform())) {
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
        isDead = true;

    }

    public Rectangle bottomBoundsPlatform() {
        return new Rectangle(this.pos.colToX(), this.pos.rowToY() + 40, 40, 40);
    }

    public Rectangle topBoundsPlatform() {
        return new Rectangle(this.pos.colToX(), this.pos.rowToY() - 40, 40, 40);
    }

    public Rectangle leftBoundsPlatform() {
        return new Rectangle(this.pos.colToX() - 40, this.pos.rowToY(), 40, 40);
    }

    public Rectangle rightBoundsPlatform() {
        return new Rectangle(this.pos.colToX() + 40, this.pos.rowToY(), 40, 40);
    }

    public Rectangle Bounds() {
        return new Rectangle(this.pos.colToX(), this.pos.rowToY(), 40, 40);
    }
}
