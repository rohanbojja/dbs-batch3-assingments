package com.rohanbojja.receiver;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import java.util.Collections;

@Configuration
@ComponentScan("com.rohanbojja.receiver")
@EnableJms
public class AppConfig {
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL("tcp://localhost:61616");
        factory.setTrustedPackages(Collections.singletonList("com.rohanbojja.receiver"));
        return factory;
    }

    @Bean
    public DefaultMessageListenerContainer messageListenerContainer() {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(activeMQConnectionFactory());
        container.setDestinationName("testQueue");
        container.setMessageListener(new MessageListenerService());

        return container;
    }


}
