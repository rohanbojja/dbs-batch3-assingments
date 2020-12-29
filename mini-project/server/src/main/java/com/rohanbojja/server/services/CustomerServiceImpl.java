package com.rohanbojja.server.services;

import com.rohanbojja.server.entities.Customer;
import com.rohanbojja.server.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Optional<Customer> create(Customer c) {
        if (c.getCustomerId() != null) {
            if (findById(c.getCustomerId()).isPresent()) {
                return Optional.empty();
            }
        }
        Customer createdCustomer = customerRepository.saveAndFlush(c);
        return Optional.of(createdCustomer);
    }

    @Override
    public List<Customer> list() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public boolean delete(Long customerId) {
        if (findById(customerId).isEmpty()) {
            return false;
        }
        customerRepository.deleteById(customerId);
        return true;
    }

    @Override
    public Optional<Customer> update(Customer c) {
        if (findById(c.getCustomerId()).isEmpty()) {
            return Optional.empty();
        }
        Customer createdCustomer = customerRepository.saveAndFlush(c);
        return Optional.of(createdCustomer);
    }

    @Override
    public Optional<Customer> toggleFavorite(Long customerId) {
        Optional<Customer> customerOptional = findById(customerId);
        if (customerOptional.isEmpty()) {
            return Optional.empty();
        }
        Customer customer = customerOptional.get();
        customer.setFavorite(!customer.isFavorite());
        return update(customer);
    }
}
