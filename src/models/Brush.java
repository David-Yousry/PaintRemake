package PaintRemake.src.models;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Brush implements Drawing{
    private ArrayList<Point> points = new ArrayList<Point>();
    private Color color;



    public Brush(Color color){
        this.color = color;
    }


    public void addPoint(int x1, int y1){
        points.add(new Point(x1,y1));
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
        
    }

    

}
