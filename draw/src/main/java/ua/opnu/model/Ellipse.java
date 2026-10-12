package ua.opnu.model;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class Ellipse extends DrawShape {

    @Override
    public Shape getShape() {
        int x = Math.min(getStartPoint().x, getEndPoint().x);
        int y = Math.min(getStartPoint().y, getEndPoint().y);
        int width = Math.abs(getStartPoint().x - getEndPoint().x);
        int height = Math.abs(getStartPoint().y - getEndPoint().y);

        return new Ellipse2D.Double(x, y, width, height);
    }
}
