package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Platform {

    private Position pos;
    private Picture platform;
    private boolean solid = true;
    public Rectangle hitbox;

    public Platform(int col, int row){
        pos = new Position(col,row);
        platform = new Picture(pos.colToX(),pos.rowToY(),"resources/PlatformMiddleRow.png");
        hitbox = new Rectangle(pos.getCol(), pos.getRow(),40, 40);
    }

    public Position getPos(){
        return pos;

    }

    public boolean isSolid(){
        return this.solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public void setPos(int x, int y){
        pos.setCol(x);
        pos.setRow(y);
    }

    public Picture getPlatform() {
        return platform;
    }

    public void delete(){
        platform.delete();
        //Null pointer Expection
        pos = null;
    }

    public void draw(){
        platform.draw();
    }
}
