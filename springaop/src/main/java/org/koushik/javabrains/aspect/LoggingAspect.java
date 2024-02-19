package org.koushik.javabrains.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {    
    @Before(value = "allCircleMethods() && allGetters()")
    public void loggingAdvice(){
        System.out.println("Advice run. Get method called");
    }
    // @Before(value = "allGetters()")
    public void secondAdvice(){
        System.out.println("Second Advice executed");
    }
    @Pointcut(value = "execution(* get*())")
    public void allGetters(){}
    // @Pointcut(value = "execution(public * org.koushik.javabrains.model.Circle.*(..))")
    // @Pointcut("within(org.koushik.javabrains.model..*)")
    @Pointcut("within(org.koushik.javabrains.model.Circle)")
    public void allCircleMethods(){}
}
