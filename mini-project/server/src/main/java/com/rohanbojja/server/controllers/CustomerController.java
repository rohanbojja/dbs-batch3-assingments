package com.rohanbojja.server.controllers;

import com.rohanbojja.server.entities.Customer;
import com.rohanbojja.server.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/")
    public ResponseEntity<Customer> create(@RequestBody final Customer c) {
        Optional<Customer> c2 = customerService.create(c);
        return c2.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> list() {
        return ResponseEntity.ok(customerService.list());
    }

    @GetMapping("/{customerId}/favorite")
    public ResponseEntity<Customer> toggleFavorite(@PathVariable final Long customerId) {
        return customerService.toggleFavorite(customerId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Boolean> delete(@PathVariable final Long customerId) {
        boolean deleted = customerService.delete(customerId);
        if (deleted) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> findById(@PathVariable final Long customerId) {
        return customerService.findById(customerId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/")
    public ResponseEntity<Customer> update(@RequestBody Customer c) {
        return customerService.update(c).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
