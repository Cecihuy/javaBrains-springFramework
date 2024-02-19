package org.koushik.javabrains.aspect;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
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
    public void loggingAdvice(){
        System.out.println("Logging from the advice");
    }
}
