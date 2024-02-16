package org.koushik.javabrains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;

@Component
public class Circle implements Shape{
    private Point center;
    @Autowired
    private MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
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
        System.out.println(this.messageSource.getMessage("greeting", null, "Default Greeting", null));
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
