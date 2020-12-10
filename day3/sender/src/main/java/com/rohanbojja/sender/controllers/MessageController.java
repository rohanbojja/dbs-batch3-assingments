package com.rohanbojja.sender.controllers;

import com.rohanbojja.sender.models.Message;
import com.rohanbojja.sender.service.MessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {

    @Autowired
    MessageSenderService messageSenderService;

    @PostMapping("send_message")
    public ModelAndView send(@ModelAttribute Message message){
        messageSenderService.sendMessage(message.getMsg());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        return modelAndView;
    }
}
