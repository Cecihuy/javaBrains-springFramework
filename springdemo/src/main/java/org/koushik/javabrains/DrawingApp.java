package org.koushik.javabrains;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
    public static void main(String[] args) {        
        AbstractApplicationContext abstractApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        abstractApplicationContext.registerShutdownHook();
        Triangle triangle = (Triangle) abstractApplicationContext.getBean("triangle");

        triangle.draw();
    }
}