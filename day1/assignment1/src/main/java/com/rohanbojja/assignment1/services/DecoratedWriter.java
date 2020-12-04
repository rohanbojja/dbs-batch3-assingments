package com.rohanbojja.assignment1.services;

import org.springframework.stereotype.Service;

@Service
public class DecoratedWriter implements Writer {
    @Override
    public void write(String message) {
        System.out.println("DECORATED!\n" + message);
    }
}
