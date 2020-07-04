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
        return customerDAO.getOne(id);
    }

    @Override
    public boolean create(Customer customer) {
        // Check exist telephone
        if (customerDAO.findByTelephone(customer.getTelephone()) != null){
            customerDAO.save(customer);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        // check exist telephone
        Customer existing = customerDAO.getOne(customer.getId());
        if ( existing != null ){
            customerDAO.save(customer);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        // check exist customer with id : id
        if (customerDAO.getOne(id) != null){

        }
        return false;
    }
}