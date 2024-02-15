package org.koushik.javabrains;

import org.springframework.beans.factory.annotation.Autowired;

public class Circle implements Shape{
    private Point center;

    public Point getCenter() {
        return center;
    }
    @Autowired
    public void setCenter(Point center) {
        this.center = center;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
        System.out.println("Circle point is: (" + center.getX() + ", " + center.getY() + ")");
    }

}
