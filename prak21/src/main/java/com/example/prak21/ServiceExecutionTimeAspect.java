package com.example.prak21;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceExecutionTimeAspect {
    private static final Logger log = LoggerFactory.getLogger(ServiceExecutionTimeAspect.class);
    private long startTime;

    @Before("execution(* com.example.prak21.ProductService.*(..))")
    public void beforeMethodExecution() {
        startTime = System.currentTimeMillis();
    }

    @After("execution(* com.example.prak21.ProductService.*(..))")
    public void afterMethodExecution(JoinPoint joinPoint) {
        long executionTime = System.currentTimeMillis() - startTime;
        log.info("Method " + joinPoint.getSignature() + " runs " + executionTime + " ms");
    }

}
