package org.koushik.javabrains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware{
    private Point center;
    private ApplicationEventPublisher publisher;    
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
        System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default drawing message", null));
        System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {center.getX(), center.getY()}, "Default point message", null));
        DrawEvent drawEvent = new DrawEvent(this);
        publisher.publishEvent(drawEvent);
    }
    @PostConstruct
    public void initializeCircle(){
        System.out.println("Init of Circle");
    }
    @PreDestroy
    public void destroyCircle(){
        System.out.println("Destroy of Circle");
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
