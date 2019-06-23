package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Platform {

    private Position pos;
    private Picture platform;
    private boolean solid = true;

    public Platform(int col, int row){
        pos = new Position(col,row);
        platform = new Picture(pos.colToX(),pos.rowToY(),"resources/Platform.PNG");
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
    }

    public void draw(){
        platform.draw();
    }

    public Rectangle bounds(){
        return new Rectangle(this.pos.colToX(),this.pos.rowToY(),40,40);
    }

}
