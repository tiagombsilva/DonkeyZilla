package org.academiadecodigo.codezillas.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Platform extends Picture {

    private Position pos;
    private Picture platform;
    private boolean solid = true;

    public Platform(int col, int row){
        pos = new Position(col,row);
        platform = new Picture(pos.colToX(), pos.rowToY(), "resources/PlatformMiddleRow.png");
    }

    public void setPos(int x,int y){
        pos.setCol(x);
        pos.setRow(y);
    }

    public Picture getPlatform() {
        return platform;
    }

    @Override
    public void delete(){
        super.delete();
        //Null pointer Expection
        pos = null;
    }

    @Override
    public void draw(){
        super.draw();
        platform.draw();
    }
}
