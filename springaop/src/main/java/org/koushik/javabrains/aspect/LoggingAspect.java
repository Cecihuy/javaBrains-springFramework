package org.koushik.javabrains.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {    
    @Before(value = "allCircleMethods()")
    public void loggingAdvice(JoinPoint joinPoint){
        
    }
    @Around(value = "allGetters()")
    public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){        
        Object returnValue = null;
        try {
            System.out.println("before proceed");
            proceedingJoinPoint.proceed();
            System.out.println("after proceed");
        } catch (Throwable e) {
            System.out.println("after proceed inside catch block");
        }
        System.out.println("After finally");
        return returnValue;
    }
    @Pointcut(value = "execution(* get*())")
    public void allGetters(){
    }
    @Pointcut(value = "within(org.koushik.javabrains.model.Circle)")
    public void allCircleMethods(){        
    }
}
