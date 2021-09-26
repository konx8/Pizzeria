package com.example.Pizza.repository;

import com.example.Pizza.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Boolean existsByName(String name);

    @Query(value = "SELECT TOP 1 id FROM CUSTOMER WHERE name = name", nativeQuery = true)
    Long getIdByName(String name);

}
