package org.academiadecodigo.codezillas;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Canvas {

    public static final int CELL_SIZE = 40;

    public static Rectangle CANVAS = null;

    public Canvas(){
        CANVAS = new Rectangle(0,0,(CELL_SIZE)*30,(CELL_SIZE)*20);
    }

}
