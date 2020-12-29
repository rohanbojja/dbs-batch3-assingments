package com.rohanbojja.server.services;

import com.rohanbojja.server.entities.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CustomerService {
    Optional<Customer> create(Customer c);

    List<Customer> list();

    Optional<Customer> findById(Long customerId);

    boolean delete(Long customerId);

    Optional<Customer> update(Customer c);

    Optional<Customer> toggleFavorite(Long customerId);
}
