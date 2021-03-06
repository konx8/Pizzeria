package com.example.Pizza.repository;

import com.example.Pizza.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Boolean existsByName(String name);

    @Query(value = "SELECT * FROM CUSTOMER WHERE name = :name", nativeQuery = true)
    Long getIdByName(String name);

    @Query(value = "SELECT * FROM CUSTOMER WHERE id = :id", nativeQuery = true)
    Customer getCustomerById(Long id);

    @Query(value = "SELECT name FROM CUSTOMER WHERE id = :id", nativeQuery = true)
    String getCustomerByName(Long id);

}
