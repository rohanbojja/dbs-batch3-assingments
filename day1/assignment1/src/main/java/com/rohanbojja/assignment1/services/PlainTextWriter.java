package com.rohanbojja.assignment1.services;

import org.springframework.stereotype.Service;

@Service
public class PlainTextWriter implements Writer {
    @Override
    public void write(String message) {
        System.out.println("Plain Text!\n" + message);
    }
}
