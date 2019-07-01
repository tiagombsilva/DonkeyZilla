package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.codezillas.AssetPaths;
import org.academiadecodigo.codezillas.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Projectile {

    private Position pos;
    private Picture fireball;
    private boolean middleScreen;
    private boolean moving;

    public Projectile(int col, int row) {
        pos = new Position(col, row);
        fireball = new Picture(pos.colToX(), pos.rowToY(), AssetPaths.FIRE_BALL);
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving() {
        this.moving = true;
    }

    private void setPos(int x,int y) {
        pos.setCol(x);
        pos.setRow(y);
    }

    public boolean isMiddleScreen() {
        return middleScreen;
    }

    private void resetFireball() {
        fireball = new Picture(pos.colToX(), pos.rowToY(), AssetPaths.FIRE_BALL);
    }

    public void fallingDown() {
        if(moving) {
            outOfScreen();
            pos.setRow(pos.getRow() + 1);
            fireball.translate(0, Canvas.CELL_SIZE);

            if (this.pos.rowToY() > Canvas.CANVAS.getHeight()/2) {
                middleScreen = true;
            }
        }
    }

    private void outOfScreen() {
        if (this.pos.rowToY() > Canvas.CANVAS.getHeight()) {
            this.fireball.delete();
            this.setPos((int)(Math.random() * 30), -1);
            this.resetFireball();
            this.middleScreen = false;
            this.fireball.draw();
        }
    }

    public void draw() {
        fireball.draw();
    }

    Rectangle bounds(){
        return new Rectangle(this.pos.colToX(),this.pos.rowToY(),Canvas.CELL_SIZE,Canvas.CELL_SIZE);
    }
}
