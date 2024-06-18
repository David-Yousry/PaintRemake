package PaintRemake.src.models;

public class Oval extends Shape {

    private int width, height;

    public Oval(int x1, int y1, boolean isSolid, int width, int height) {
        super(x1, y1, isSolid);
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
