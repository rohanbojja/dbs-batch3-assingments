package com.rohanbojja.sender;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Arrays;

@Configuration
@ComponentScan(basePackages = "com.rohanbojja.sender")
@EnableJms
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver veiwResolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/WEB-INF/pages/");
        vr.setSuffix(".jsp");
        return vr;
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
        cf.setBrokerURL("tcp://localhost:61616");
        cf.setTrustedPackages(Arrays.asList("com.rohanbojja.sender"));
        return cf;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDefaultDestinationName("testQueue");
        return jmsTemplate;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/send").setViewName("sender");
        registry.addViewController("/result").setViewName("result");
    }


}