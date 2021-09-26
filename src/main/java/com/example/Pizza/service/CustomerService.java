package com.example.Pizza.service;

import com.example.Pizza.entity.Customer;
import com.example.Pizza.entity.Order;
import com.example.Pizza.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepo customerRepo;


    public Iterable<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    public Customer addCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public Boolean ifExist(String name){
        return customerRepo.existsByName(name);
    }

    public Customer getCustomer(Long id){
        return customerRepo.getById(id);
    }

    public Long getIdByCustomerName(String name) throws NonUniqueResultException {
        return customerRepo.getIdByName(name);
    }


}
