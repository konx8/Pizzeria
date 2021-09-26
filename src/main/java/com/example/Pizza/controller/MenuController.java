package com.example.Pizza.controller;

import com.example.Pizza.entity.OrderProduct;
import com.example.Pizza.service.CustomerService;
import com.example.Pizza.service.OrderProductService;
import com.example.Pizza.service.OrderService;
import com.example.Pizza.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@AllArgsConstructor
public class MenuController {

    public ProductService productService;
    public CustomerService customerService;
    public OrderService orderService;
    public OrderProductService orderProductService;
    public MainPageController mainPageController;

    @GetMapping("/menu")
    public String getAllProductList(Model model){
        model.addAttribute("products", productService.getProductsList() );
        //model.addAttribute("addProduct", orderProductService.saveSingleProduct())
        model.addAttribute("addOrders", new OrderProduct());
        model.addAttribute("customer", customerService.getCustomer(getOrderIdByCustomerName()));
        model.addAttribute("name", mainPageController.returnCustomerName());

        return "menu";
    }

    public Long getOrderIdByCustomerName(){
        Long customerId = customerService.getIdByCustomerName(mainPageController.returnCustomerName());
        return orderService.getOrderIdByCustomerID(customerId);
    }


    public Long getIdProduct(){


        return null;
    }


}
