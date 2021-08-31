package com.example.Pizza.controller;


import com.example.Pizza.entity.Order;
import com.example.Pizza.entity.OrderProduct;
import com.example.Pizza.service.OrderService;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private OrderService orderService;


    @GetMapping("/orders")
    ResponseEntity<?> getOrder(){
        return ResponseEntity.ok(orderService.getOrders());
    }

    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }





//    @GetMapping("/order")
//    public Set<OrderProduct> getCustomerOrder(@RequestParam(name = "Id")Long ordersId){
//        return orderService.getProducts(ordersId);
//    }


//    @GetMapping("/showOrder")
//    public Set<Order> showOrder(@RequestParam(name = "orderId")Long orderId) {
//        return (Set<Order>) orderService.(orderId);
//    }


}
