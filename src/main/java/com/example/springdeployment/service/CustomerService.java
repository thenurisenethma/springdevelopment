package com.example.springdeployment.service;

import com.example.springdeployment.entity.Customer;
import com.example.springdeployment.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public CustomerRepo getCustomerRepo() {
        return customerRepo;
    }

    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
    public Customer saveCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer UpdateCustomer(Customer customer) {
        return customerRepo.update(customer);
    }


}
