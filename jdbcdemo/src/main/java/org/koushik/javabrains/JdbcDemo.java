package org.koushik.javabrains;
import org.koushik.javabrains.dao.JdbcDaoImpl;
import org.koushik.javabrains.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcDaoImpl dao = applicationContext.getBean("jdbcDaoImpl", JdbcDaoImpl.class);

        // Circle circle = dao.getCircle(1);
        // System.out.println(circle.getName());

        // System.out.println(dao.getCircleForId(1).getName());
        // System.out.println(dao.getAllCircles().size());

        // dao.insertCircle(new Circle(2, "Second Circle"));
        // dao.insertCircle(new Circle(3, "Third Circle"));
        // System.out.println(dao.getAllCircles().size());

        dao.insertCircle(new Circle(4, "Fourth Circle"));
        System.out.println(dao.getAllCircles().size());
    }
}