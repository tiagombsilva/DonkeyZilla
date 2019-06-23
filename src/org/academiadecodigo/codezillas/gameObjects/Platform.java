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
        hitbox = new Rectangle(col, row, 40, 40);
    }

    public Position getPos(){
        return pos;

    }

    public boolean isSolid(){
        return solid;
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

        //setPos(100,0);
        //platform.translate(100,0);
        platform.delete();
        //Null pointer Expection

    }

    public void draw(){
        platform.draw();
    }
}
