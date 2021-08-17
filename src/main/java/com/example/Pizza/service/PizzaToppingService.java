package com.example.Pizza.service;


import com.example.Pizza.entity.Pizza;
import com.example.Pizza.entity.PizzaTopping;
import com.example.Pizza.repository.PizzaToppingRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
@AllArgsConstructor
public class PizzaToppingService {

    private PizzaToppingRepo pizzaToppingRepo;


    public Iterable<PizzaTopping> getAllPizzaTopping() {
        return pizzaToppingRepo.findAll();
    }
    public Iterable<PizzaTopping> saveListPizzaTopping(List<PizzaTopping> pizzaToppings) {
        return pizzaToppingRepo.saveAll(pizzaToppings);
    }



}
