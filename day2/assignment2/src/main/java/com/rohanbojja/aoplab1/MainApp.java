package com.rohanbojja.aoplab1;

import com.rohanbojja.aoplab1.services.Target;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Target target = applicationContext.getBean(Target.class);
        target.doConcat("Rohan","Bojja");
    }
}
