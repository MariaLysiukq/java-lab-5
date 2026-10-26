package ua.opnu.model;

import java.awt.Point;
import java.awt.Shape;

public abstract class DrawShape {

    public static final int SHAPE_RECTANGLE = 0;
    public static final int SHAPE_ROUNDED_RECT = 1;
    public static final int SHAPE_ELLIPSE = 2;

    private Point startPoint;
    private Point endPoint;

    public DrawShape() {
    }

    public DrawShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public static DrawShape newInstance(int type) {
        switch (type) {
            case SHAPE_RECTANGLE:
                return new Rectangle();
            case SHAPE_ROUNDED_RECT:
                return new RoundedRectangle();
            case SHAPE_ELLIPSE:
                return new Ellipse();
            default:
                return null;
        }
    }

    public abstract Shape getShape();

    public Shape getShape(Point startPoint, Point endPoint) {
        setStartPoint(startPoint);
        setEndPoint(endPoint);
        return getShape();
    }
}