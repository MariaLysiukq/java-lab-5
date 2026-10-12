package ua.opnu.model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

public class RoundedRectangle extends DrawShape {

    public RoundedRectangle() {
    }

    public RoundedRectangle(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    @Override
    public Shape getShape() {
        if (getStartPoint() == null || getEndPoint() == null) return null;
        int x = Math.min(getStartPoint().x, getEndPoint().x);
        int y = Math.min(getStartPoint().y, getEndPoint().y);
        int width = Math.abs(getStartPoint().x - getEndPoint().x);
        int height = Math.abs(getStartPoint().y - getEndPoint().y);

        return new RoundRectangle2D.Double(x, y, width, height, 20, 20);
    }
}
