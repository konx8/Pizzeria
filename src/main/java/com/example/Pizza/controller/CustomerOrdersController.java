package com.example.Pizza.controller;

import com.example.Pizza.entity.Order;
import com.example.Pizza.service.CustomerService;
import com.example.Pizza.service.OrderProductService;
import com.example.Pizza.service.OrderService;
import com.example.Pizza.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;

@Controller
@AllArgsConstructor
public class CustomerOrdersController {

    public ProductService productService;
    public CustomerService customerService;
    public OrderService orderService;
    public OrderProductService orderProductService;
    public static boolean status;


    @GetMapping("/customerOrders/{id}")
    public String getAllProductList(Model model, @PathVariable Long id){
        model.addAttribute("userId", id);
        model.addAttribute("orders", orderProductService.listOfOrderedProductView(orderService.findLastId(id)));
        return "customerOrders";
    }

    @GetMapping("/email/{id}")
    public String sendEmail(@PathVariable Long id) throws MessagingException {
        orderProductService.dataToEmail(customerService.getCustomerByName(id),id);
        //addNewOrder(id);
        status = true;
        return "redirect:/customerOrders/" + id;
    }

    @PostMapping("/deleteOrder/{orderId}")
    public String deleteOrder(@PathVariable Long orderId){
        orderProductService.deleteOrder(orderId);
        return "redirect:/customerOrders/" + orderId ;
    }

    @GetMapping("/addNewOrder/{id}")
    public String addNewOrder(@PathVariable Long id){
        if(status){
            orderService.addOrder(new Order(customerService.getCustomerById(id)));
        }else {
            if (orderProductService.findByLastRecord().getId() == null){
                orderService.addOrder(new Order(customerService.getCustomerById(id)));
            }else {
                orderProductService.deleteOrder(orderProductService.findByLastRecord().getId());
            }
        }
        status = false;
        return "redirect:/menu/" + id;
    }

}
