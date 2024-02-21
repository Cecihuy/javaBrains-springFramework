package org.koushik.javabrains;
import org.koushik.javabrains.dao.JdbcDaoImpl;
import org.koushik.javabrains.dao.SimpleJdbcDaoImpl;
import org.koushik.javabrains.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        // JdbcDaoImpl dao = applicationContext.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
        SimpleJdbcDaoImpl dao = applicationContext.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class);
        
        System.out.println(dao.getCircleCount());


    }
}