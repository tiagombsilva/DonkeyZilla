package org.academiadecodigo.codezillas;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Canvas {

    public static final int CELLSIZE = 40;

    private Rectangle canvas;

    public Canvas(){
        canvas = new Rectangle(0,0,(CELLSIZE)*30,(CELLSIZE)*20);
    }

    public int rowToY(int row){
        return row*CELLSIZE;
    }

    public int columToX(int col){
        return col*CELLSIZE;
    }


}
