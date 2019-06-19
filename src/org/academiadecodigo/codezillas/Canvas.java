package org.academiadecodigo.codezillas;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Canvas {
    private static final int CELLSIZE = 40;

    private Rectangle canvas;

    public void init(){
        canvas = new Rectangle(0,0,(CELLSIZE)*30,(CELLSIZE)*20);
        Picture background = new Picture(0,0,"resources/Background.png");
        canvas.draw();
        background.draw();

    }
}
