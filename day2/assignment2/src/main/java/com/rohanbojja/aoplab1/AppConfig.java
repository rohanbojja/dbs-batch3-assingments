package com.rohanbojja.aoplab1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.rohanbojja.aoplab1")
@EnableAspectJAutoProxy
public class AppConfig {
}
