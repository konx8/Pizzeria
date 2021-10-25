package com.example.Pizza.controller;

import com.example.Pizza.entity.Order;
import com.example.Pizza.service.OrderProductService;
import com.example.Pizza.service.OrderService;
import com.example.Pizza.view.OrderProductView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class HistoryController {

    public OrderProductService orderProductService;
    public OrderService orderService;

    @GetMapping("/history/{id}")
    public String history(Model model, @PathVariable Long id){

        model.addAttribute("orders", orderProductService.listOfOrderedProductView(id));
        model.addAttribute("userId", id);
        model.addAttribute("allOrders", getAllOrdersByUserId(id));
        return"history";
    }

    public  List<OrderProductView> getAllOrdersByUserId(Long id){

        List<Order> orders = orderService.findAllByCustomerId(id);
        List<List<OrderProductView>> newOrders = new ArrayList<>();
        for (Order order : orders){
            newOrders.add(orderProductService.listOfOrderedProductView(order.getId()));
        }
        List<OrderProductView> test = newOrders.stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
        return test;
    }

}
