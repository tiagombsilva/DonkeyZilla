package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.codezillas.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Platform {

    private Position pos;
    private Picture platform;
    private boolean solid = true;

    public Platform(int col, int row){
        pos = new Position(col,row);
        platform = new Picture(pos.colToX(),pos.rowToY(),"resources/PlatformMiddleRow.png");
        this.draw();
    }

    public void draw(){
        platform.draw();
    }

    public void setPos(int x,int y){
        pos.setCol(x);
        pos.setRow(y);
    }

}
