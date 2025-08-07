package com.example.springdeployment.repo;

import com.example.springdeployment.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
