package com.example.Pizza.controller;

import com.example.Pizza.service.CustomerService;
import com.example.Pizza.service.OrderProductService;
import com.example.Pizza.service.OrderService;
import com.example.Pizza.service.ProductService;
import com.example.Pizza.view.CustomerInputView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class CustomerOrdersController {

    public ProductService productService;
    public CustomerService customerService;
    public OrderService orderService;
    public OrderProductService orderProductService;
    public MenuController menuController;
    public MainPageController mainPageController;


    @GetMapping("/customerOrders")
    public String getAllProductList(Model model){
        model.addAttribute("orders", orderProductService.listOfOrderedProductView(getCustomerIdByName()));
        model.addAttribute("delete", new CustomerInputView());
        return "customerOrders";
    }

    public Long getCustomerIdByName(){
        return customerService.getIdByCustomerName(mainPageController.returnCustomerName());
    }

    @PostMapping("/deleteOrder")
    public String deleteOrder(CustomerInputView customerInputView){
        Long id = (customerInputView.getOrderId());

        if(orderProductService.existsById(id)){
            orderProductService.deleteOrder(id);
        }


        return "redirect:/customerOrders";

    }

}
