package com.rohanbojja.server;

import com.rohanbojja.server.entities.Customer;
import com.rohanbojja.server.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication implements CommandLineRunner {

    @Autowired
    CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        customerService.create(new Customer("Rohan", "44142, Road 4884, Street 5775, Banjara Hills, Hyderabad, India.", "rohanbojja@gmail.com", "12393499", true));
        customerService.create(new Customer("Abhinay", "2323, Road 23323, Street 1123, Yolo, State, India.", "abhinay@gmail.com", "9007867786", true));
        customerService.create(new Customer("Chirayu", "87066, Road 9966, Street 123897, Banjara Hills, Jaipur, India.", "chirayu@gmail.com", "128371923", false));
        customerService.create(new Customer("Shantanu", "56664, Road 9383, Street 0752, Old City, Hyderabad, India.", "shantanu@gmail.com", "838838338", false));
    }
}
