package org.koushik.javabrains.service;
import org.koushik.javabrains.aspect.LoggingAspect;
import org.koushik.javabrains.model.Circle;

public class ShapeServiceProxy extends ShapeService {
    @Override
    public Circle getCircle(){
        new LoggingAspect().loggingAdvice();    //before target method
        return super.getCircle();        
    }
}
