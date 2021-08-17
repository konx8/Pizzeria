package com.example.Pizza.repository;

import com.example.Pizza.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
