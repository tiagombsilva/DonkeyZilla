package org.academiadecodigo.codezillas;

public class Position {

    private int col;
    private int row;

    public Position(int col, int row){
        this.col = col;
        this.row = row;
    }

    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }

    public int colToX(){
        return this.col * Canvas.CELLSIZE;
    }

    public int rowToY(){
        return this.row * Canvas.CELLSIZE;
    }

    public void setCol(int col){
        this.col = col;
    }

    public void setRow(int row){
       this.row = row;
    }
}
