package com.example.Pizza.repository;

import com.example.Pizza.entity.Order;
import com.example.Pizza.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    //List<Order> findAllById(Long id);



    //Test
    //Optional<Order> findById(Long quantity);
    //@Query("SELECT order FROM OrderProduct o WHERE o.order = ?1")
    //OrderProduct findByOrderPId(Long id);

}
//    @Query("select u from User u where u.emailAddress = ?1")
//    User findByEmailAddress(String emailAddress);