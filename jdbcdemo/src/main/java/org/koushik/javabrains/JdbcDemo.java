package org.koushik.javabrains;
import org.koushik.javabrains.dao.HibernateDaoImpl;
import org.koushik.javabrains.dao.JdbcDaoImpl;
import org.koushik.javabrains.dao.SimpleJdbcDaoImpl;
import org.koushik.javabrains.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");        
        // SimpleJdbcDaoImpl dao = applicationContext.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class);
        HibernateDaoImpl dao = applicationContext.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
        
        System.out.println(dao.getCircleCount());


    }
}