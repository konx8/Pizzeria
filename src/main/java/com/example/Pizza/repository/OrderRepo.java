package com.example.Pizza.repository;

import com.example.Pizza.entity.Order;
import com.example.Pizza.view.OrderProductView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    @Query(value = "SELECT TOP 1 * FROM Orders WHERE Customer_Id = :id ORDER BY ID DESC", nativeQuery=true)
    Long lastId(Long id);

    List<Order> findAllByCustomerId(Long id);

}
