package org.koushik.javabrains.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {    
    @Before(value = "allCircleMethods()")
    public void loggingAdvice(JoinPoint joinPoint){
        
    }
    // @After("args(name)")
    // @AfterReturning("args(name)")
    @AfterReturning(pointcut = "args(name)", returning = "returnString")
    public void stringArgumentMethods(String name, String returnString){
        System.out.println("A method that takes String arguments has been called");
        System.out.println("The value is : " + name);
        System.out.println("The return is : " + returnString);
    }
    @AfterThrowing(pointcut = "args(name)", throwing = "ex")
    public void exceptionAdvice(String name, Exception ex){
        System.out.println("An exception has been thrown" +ex);
    }
    @Pointcut(value = "execution(* get*())")
    public void allGetters(){        
    }
    @Pointcut(value = "within(org.koushik.javabrains.model.Circle)")
    public void allCircleMethods(){        
    }
}
