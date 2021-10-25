package com.example.Pizza.service;

import com.example.Pizza.entity.Order;
import com.example.Pizza.repository.OrderRepo;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepo orderRepo;

    public List<Order> getOrders(){
        return orderRepo.findAll();
    }

    public Order addOrder(Order order){
        return orderRepo.save(order);
    }

    public Long findLastId(Long id){
        return orderRepo.lastId(id);
    }


    public List<Order> findAllByCustomerId(Long id){
        return orderRepo.findAllByCustomerId(id);
    }


}


