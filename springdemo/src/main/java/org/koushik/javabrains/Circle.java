package org.koushik.javabrains;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;

public class Circle implements Shape{
    private Point center;

    public Point getCenter() {
        return center;
    }
    @Resource(name = "pointC")
    public void setCenter(Point center) {
        this.center = center;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
        System.out.println("Circle point is: (" + center.getX() + ", " + center.getY() + ")");
    }
    @PostConstruct
    public void initializeCircle(){
        System.out.println("Init of Circle");
    }
    @PreDestroy
    public void destroyCircle(){
        System.out.println("Destroy of Circle");
    }
}
