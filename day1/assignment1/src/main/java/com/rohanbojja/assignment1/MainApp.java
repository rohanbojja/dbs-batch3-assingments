package com.rohanbojja.assignment1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        WriterApp writerApp =(WriterApp) applicationContext.getBean(WriterApp.class);
        writerApp.print("HOLO!");
    }
}
