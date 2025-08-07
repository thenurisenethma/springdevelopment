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

    public Customer updateCustomer(Customer customer) {
        if (!customerRepo.existsById(customer.getId())) {
            throw new RuntimeException("Customer not found to update");
        }
        return customerRepo.save(customer);
    }

    public void deleteCustomer(int id) {
        if (!customerRepo.existsById(id)) {
            throw new RuntimeException("Customer not found to delete");
        }
        customerRepo.deleteById(id);
    }
}
