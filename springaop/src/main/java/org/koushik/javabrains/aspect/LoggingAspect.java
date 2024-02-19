package org.koushik.javabrains.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.koushik.javabrains.model.Circle;

@Aspect
public class LoggingAspect {    
    @Before(value = "allCircleMethods()")
    public void loggingAdvice(JoinPoint joinPoint){
        System.out.println(joinPoint.toString());
        System.out.println(joinPoint.getTarget());
        Circle circle = (Circle) joinPoint.getTarget(); //we can use this circle variable for different scenario
    }
    // @Before("args(String)")
    @Before("args(name)")
    public void stringArgumentMethods(String name){
        System.out.println("A method that takes String arguments has been called");
        System.out.println("The value is : " + name);
    }
    @Pointcut(value = "execution(* get*())")
    public void allGetters(){        
    }
    @Pointcut("within(org.koushik.javabrains.model.Circle)")
    public void allCircleMethods(){        
    }
}
