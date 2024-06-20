package PaintRemake.src.models;

import java.awt.Color;

public class Oval extends Shape {

    private int width, height;

    public Oval(int x1, int y1, boolean isSolid, int width, int height, Color color) {
        super(x1, y1, isSolid, color);
        this.width = width;
        this.height = height;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
