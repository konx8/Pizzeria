package com.example.Pizza.api;

import com.example.Pizza.entity.Customer;
import com.example.Pizza.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/customers")
    public Iterable<Customer> getCustomers(){
        return customerService.getCustomers();
    }


}
