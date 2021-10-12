package com.example.Pizza.service;

import com.example.Pizza.entity.Order;
import com.example.Pizza.repository.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepo orderRepo;

    public List<Order> getOrders(){
        return (List<Order>) orderRepo.findAll();
    }

    public Order addOrder(Order order){
        return orderRepo.save(order);
    }
    public Long findLastId(){
        return orderRepo.lastId();
    }

    public Long getOrderIdByCustomerID(Long id){
        return orderRepo.getOrderIdByCustomerID(id);
    }



}


