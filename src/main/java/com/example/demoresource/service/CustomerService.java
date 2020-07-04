package com.example.demoresource.service;

import com.example.demoresource.model.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer getById(Long id);
    boolean create(Customer customer);
    boolean update(Customer customer);
    boolean deleteById(Long id);
}
