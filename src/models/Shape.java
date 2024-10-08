package PaintRemake.src.models;

import java.awt.Color;

public class Shape implements Drawing {
    

    private int x1,y1;
    private boolean isSolid;
    private Color color;

    public Shape(int x1,int y1, boolean isSolid, Color color){
        this.x1 = x1;
        this.y1 = y1;
        this.isSolid = isSolid;
        this.color = color;
    }




    public int getX1() {
        return x1;
    }
    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }
    public void setY1(int y1) {
        this.y1 = y1;
    }

    public boolean isSolid() {
        return isSolid;
    }
    
    public void setSolid(boolean isSolid) {
        this.isSolid = isSolid;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    


}
