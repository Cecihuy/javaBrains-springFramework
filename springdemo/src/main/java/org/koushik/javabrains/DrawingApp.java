package org.koushik.javabrains;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
    public static void main(String[] args) {        
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");
        Triangle triangle = (Triangle) beanFactory.getBean("triangle");

        triangle.draw();
    }
}