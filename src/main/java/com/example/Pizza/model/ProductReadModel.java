package com.example.Pizza.model;

import com.example.Pizza.entity.Product;
import lombok.Data;

@Data
public class ProductReadModel {

    public String name;
    public ProductReadModel(Product productName) {
        name = productName.getName();
    }

}
