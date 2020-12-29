package com.rohanbojja.server.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue
    private Long customerId;
    @NotBlank(message = "Customer name is required.")
    @Size(min = 3, max = 50)
    private String customerName;
    @NotBlank(message = "An address is required.")
    @Size(min = 10, max = 255)
    private String address;
    @Email
    @NotBlank(message = "Email address is required.")
    @Size(min = 7, max = 255)
    private String email;
    @Size(min=10, max = 10)
    @NotBlank(message = "Mobile number is required.")
    private String mobileNo;
    private boolean favorite;
}
