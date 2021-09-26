package com.example.Pizza.controller;

import com.example.Pizza.entity.Product;
import com.example.Pizza.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductService productService;


    @GetMapping("/products")
    public Iterable<Product> getAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/list")
    public List<Product> getAllPList(){
        return productService.getProductsList();
    }

}
