package org.koushik.javabrains;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
    public static void main(String[] args) {        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Triangle triangle = (Triangle) applicationContext.getBean("triangle1");

        triangle.draw();
    }
}