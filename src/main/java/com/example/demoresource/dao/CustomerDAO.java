package com.example.demoresource.dao;

import com.example.demoresource.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Long> {
    Customer findByTelephone(String telephone);
}
