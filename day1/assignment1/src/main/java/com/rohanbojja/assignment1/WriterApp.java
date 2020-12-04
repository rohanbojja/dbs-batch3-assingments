package com.rohanbojja.assignment1;

import com.rohanbojja.assignment1.services.DecoratedWriter;
import com.rohanbojja.assignment1.services.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class WriterApp {

    @Autowired
    DecoratedWriter decoratedWriter;

    @Autowired
    @Qualifier("plainTextWriter")
    Writer writer;

    public void print(String message) {
        decoratedWriter.write(message);
        System.out.println("\n\n\n");
        writer.write(message);
    }
}
