package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Projectile extends Picture {

    private Position pos;

    private Picture fireball;


    ///////Para parar o projetil uma beca quando chega ao fim do ecra, meter false dentro do IF e meter true no While!!!!
    public boolean moving;

    public Projectile(int col, int row) {
        pos = new Position(col, row);
        fireball = new Picture(pos.colToX(),pos.rowToY(), "resources/FireProjectile.png");
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(int x,int y) {
        pos.setCol(x);
        pos.setRow(y);
    }

    public void resetFireball() {
        //fireball.translate(pos.colToX(), pos.rowToY());
        fireball = new Picture(pos.colToX(), pos.rowToY(), "resources/FireProjectile.png");
    }

    public void fallingDown() {
        pos.setRow(pos.getRow()+20);
        fireball.translate(0,20);
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

}
