package com.example.custom_annotation.annotations.processor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationProcessorAOP {

    @Around("@annotation(com.example.custom_annotation.annotations.LogTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.nanoTime();
        Object proceed = joinPoint.proceed();
        long endTime = System.nanoTime();
        System.out.printf("The execution time for method %s is: %d\n", joinPoint.getSignature(), (endTime-startTime));
        return proceed;
    }
}
