package org.koushik.javabrains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle implements Shape{
    private Point center;

    public Point getCenter() {
        return center;
    }
    @Autowired
    @Qualifier(value = "circleRelated")
    public void setCenter(Point center) {
        this.center = center;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
        System.out.println("Circle point is: (" + center.getX() + ", " + center.getY() + ")");
    }
}
