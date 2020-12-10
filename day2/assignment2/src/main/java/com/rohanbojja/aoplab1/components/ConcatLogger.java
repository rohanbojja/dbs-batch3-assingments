package com.rohanbojja.aoplab1.components;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ConcatLogger {
    @Pointcut("execution(* com.rohanbojja.aoplab1.services.*.perform(..))")
    public void pcut() {
    }

    @Before("pcut() && args(s1,s2)")
    public void before(String s1, String s2){
        System.out.println("Input parameters: "+s1+", "+s2);
    }

    @AfterReturning("pcut() && args(s1)")
    public void afterReturning(String s1, String s2){
        System.out.println("Final String: ");
    }
}
