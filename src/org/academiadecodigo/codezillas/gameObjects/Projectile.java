package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Projectile extends Picture {

    private Position pos;
    private Picture fireball;
    private boolean middleScreenPosition;
    private boolean moving;
    public Rectangle hitbox;

    public Projectile(int col, int row) {
        pos = new Position(col, row);
        fireball = new Picture(pos.colToX(),pos.rowToY(), "resources/FireProjectile.png");
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving() {
        this.moving = true;
    }

    public Position getPos() {
        return pos;
    }

    public  void setPos(int x,int y) {
        pos.setCol(x);
        pos.setRow(y);
    }

    public boolean isMiddleScreenPosition() {
        return middleScreenPosition;
    }

    private void resetFireball() {
        fireball = new Picture(pos.colToX(), pos.rowToY(), "resources/FireProjectile.png");
    }

    public void fallingDown() {
        if(moving) {
            outOfBounds();
            pos.setRow(pos.getRow() + 1);
            fireball.translate(0, 40);

            if (this.pos.rowToY() > 425) {
                middleScreenPosition = true;
            }
        }
    }

    private void outOfBounds() {
        if (this.pos.rowToY() > 850) {
            this.setPos((int)(Math.random() * 30), -1);
            this.resetFireball();
            this.middleScreenPosition = false;
            this.draw();

        }
    }

    @Override
    public void delete() {
        super.delete();
        //Null pointer Expection
        //pos = null;
    }

    @Override
    public void draw() {
        super.draw();
        fireball.draw();
    }

    public Rectangle bounds(){
        return new Rectangle(this.pos.colToX(),this.pos.rowToY(),40,40);
    }
}
