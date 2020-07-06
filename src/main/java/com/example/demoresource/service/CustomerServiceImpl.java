package com.example.demoresource.service;

import com.example.demoresource.dao.CustomerDAO;
import com.example.demoresource.model.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<Customer> getAll() {
        return customerDAO.findAll();
    }

    @Override
    public Customer getById(Long id) {
        if (customerDAO.findById(id).isPresent()) {
            return customerDAO.findById(id).get();
        }
        return null;
    }

    @Override
    public boolean create(Customer customer) {
        // Check exist telephone
        if (customerDAO.findByTelephone(customer.getTelephone()) == null) {
            customerDAO.save(customer);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        // check exist customer
        if (customerDAO.findById(customer.getId()).isPresent()) {
            Customer existing = customerDAO.findById(customer.getId()).get();
            if (customerDAO.findByTelephone(customer.getTelephone()) == null ||
                customerDAO.findByTelephone(customer.getTelephone()).getId().equals(existing.getId())) {
                customerDAO.save(customer);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        if (customerDAO.findById(id).isPresent()) {
            customerDAO.deleteById(id);
        }
        return false;
    }
}
