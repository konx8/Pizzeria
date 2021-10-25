package com.example.Pizza.service;

import com.example.Pizza.entity.Product;
import com.example.Pizza.repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepo productRepo;

    public Iterable<Product> getProducts(){
        return productRepo.findAll();
    }

    public List<Product> getProductsList(){
        return productRepo.findAll();
    }


}
