package com.example.Pizza.repository;

import com.example.Pizza.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepo extends JpaRepository<OrderProduct, Long> {


    @Query("select c from Customer c where c.id =?1")
    Iterable<OrderProduct> findByCustomerId(@Param("id") Long id);

    List<OrderProduct> findByOrderId(Long id);

    @Query(value = "SELECT * FROM ORDER_PRODUCT where order_id = ?1" , nativeQuery=true)
    List<OrderProduct> findAllOrderProductByOrderID(Long orderId);

    boolean existsById(Long id);

}
