package com.example.Pizza.controller;

import com.example.Pizza.entity.OrderProduct;
import com.example.Pizza.service.CustomerService;
import com.example.Pizza.service.OrderProductService;
import com.example.Pizza.service.OrderService;
import com.example.Pizza.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
public class MenuController {

    public ProductService productService;
    public CustomerService customerService;
    public OrderService orderService;
    public OrderProductService orderProductService;
    public MainPageController mainPageController;

    @GetMapping(value ="/menu/{id}")
    public String getAllProductList(@PathVariable Long id, Model model) {

        model.addAttribute("products", productService.getProductsList() );
        model.addAttribute("dataToProductList", new OrderProduct());
        model.addAttribute("customer", customerService.getCustomer(id));
        model.addAttribute("bill", customerBill(id));
        model.addAttribute("userId", id);
        return "menu";
    }

    @PostMapping(value ="/order/{id}")
    public String setOrder(@ModelAttribute OrderProduct orderProduct, @PathVariable Long id){


        orderProductService.saveSingleProduct(orderProduct,orderService.findLastId(id));
        return "redirect:/menu/" + id;
    }

    @GetMapping("/bill")
    public int customerBill(Long id) {
        return orderProductService.getBill(orderService.findLastId(id));
    }



}
