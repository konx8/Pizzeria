package com.example.Pizza.api;


import com.example.Pizza.entity.Order;
import com.example.Pizza.repository.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderController {

    private OrderRepo orderRepo;

    @GetMapping("/orders")
    public Iterable<Order> getOrders() {
        return orderRepo.findAll();
    }

}
