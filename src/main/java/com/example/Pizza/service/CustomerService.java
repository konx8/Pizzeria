package com.example.Pizza.service;

import com.example.Pizza.entity.Customer;
import com.example.Pizza.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepo customerRepo;

    public Iterable<Customer> getCustomers(){
        return customerRepo.findAll();
    }


}
