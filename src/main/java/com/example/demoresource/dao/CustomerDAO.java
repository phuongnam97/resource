package com.example.demoresource.dao;

import com.example.demoresource.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerDAO extends CrudRepository<Customer, Long> {
    Customer findByTelephone(String telephone);
    List<Customer> findAll();
}
