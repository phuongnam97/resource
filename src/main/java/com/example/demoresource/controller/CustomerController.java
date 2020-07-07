package com.example.demoresource.controller;

import com.example.demoresource.model.Customer;
import com.example.demoresource.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAll() {
        if (customerService.getAll() == null || customerService.getAll().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getById(
            @PathVariable("id") Long id
    ){
        if (customerService.getById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        if (!customerService.create(customer)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("/customer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        if (!customerService.update(customer)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
        Customer existing = customerService.getById(id);
        if (existing == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (customerService.deleteById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(existing, HttpStatus.OK);
    }
}
