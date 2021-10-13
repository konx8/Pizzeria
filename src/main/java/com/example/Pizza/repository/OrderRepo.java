package com.example.Pizza.repository;

import com.example.Pizza.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {


    @Query(value = "SELECT TOP 1 * FROM Orders ORDER BY ID DESC", nativeQuery=true)
    Long lastId();

    @Query(value = "SELECT ID FROM Orders WHERE Customer_Id = 1", nativeQuery = true)
    Long getOrderIdByCustomerID(Long id);


}
