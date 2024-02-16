package org.koushik.javabrains;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
    public static void main(String[] args) {        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Shape shape = (Shape) applicationContext.getBean("circle");
        shape.draw();
        System.out.println(applicationContext.getMessage("greeting", null, "Default Greeting", null));
    }
}