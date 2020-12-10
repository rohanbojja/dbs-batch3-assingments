package com.rohanbojja.sender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

@Service
public class MessageSenderService {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(String txt) {
        jmsTemplate.send(session -> {

            TextMessage msg = session.createTextMessage();
            msg.setText(txt);

            return msg;
        });
    }
}
