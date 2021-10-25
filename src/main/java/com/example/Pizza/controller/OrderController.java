package com.example.Pizza.controller;


import com.example.Pizza.entity.Order;
import com.example.Pizza.service.OrderService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping("/orders")
    ResponseEntity<?> getOrder(){
        return ResponseEntity.ok(orderService.getOrders());
    }

    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }





}
