package org.koushik.javabrains.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
    // @Before("execution(public String org.koushik.javabrains.model.Circle.getName())")
    // @Before("execution(public * get*())")
    // @Before("execution(public * get*(*))")
    // @Before("execution(public * get*(..))")
    // @Before("execution(public * org.koushik.javabrains.model.*.get*())")
    @Before(value = "allGetters()")
    public void loggingAdvice(){
        System.out.println("Advice run. Get method called");
    }
    @Before(value = "allGetters()")
    public void secondAdvice(){
        System.out.println("Second Advice executed");
    }
    @Pointcut(value = "execution(* get*())")
    public void allGetters(){}
}
