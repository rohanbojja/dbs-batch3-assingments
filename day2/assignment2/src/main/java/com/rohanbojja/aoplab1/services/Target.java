package com.rohanbojja.aoplab1.services;

import org.springframework.stereotype.Service;

@Service
public class Target {
    public String doConcat(String s1, String s2){
        return s1+" "+s2;
    }
}
