package com.example.Pizza.controller;

import com.example.Pizza.entity.Customer;
import com.example.Pizza.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/customers")
    public Iterable<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }



}
