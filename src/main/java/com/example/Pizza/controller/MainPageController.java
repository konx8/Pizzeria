package com.example.Pizza.controller;

import com.example.Pizza.entity.Customer;
import com.example.Pizza.entity.Order;
import com.example.Pizza.entity.OrderProduct;
import com.example.Pizza.service.CustomerService;
import com.example.Pizza.service.OrderProductService;
import com.example.Pizza.service.OrderService;
import com.example.Pizza.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
@Data
public class MainPageController{

    public ProductService productService;
    public CustomerService customerService;
    public OrderService orderService;
    public OrderProductService orderProductService;
    static String nameCUST;

    @GetMapping("/home")
    public String getAllProductList(Model model){
        model.addAttribute("addCust", new Customer());
        return "mainPage";
    }

    @PostMapping("/cus")
    public String addCustomer(@ModelAttribute Customer customer) {
        if(customer.getName().isEmpty()){
            return "redirect:/home";
        }else {
            if (customerService.ifExist(customer.getName())) {
                return "redirect:/customerOrders";
            } else {
                customerService.addCustomer(customer);
                orderService.addOrder(new Order(customer));
                customerName(customer);
                return "redirect:/menu";
            }
        }
    }

    public String customerName(Customer customer) {
        nameCUST = customer.getName();
        return nameCUST;
    }

    public String returnCustomerName() {
        return nameCUST;
    }


    @PostMapping("/order")
    public String setOrder(@ModelAttribute OrderProduct orderProduct){
        orderProductService.saveSingleProduct(orderProduct, orderService.findLastId());
        return "redirect:/menu";
    }



}
