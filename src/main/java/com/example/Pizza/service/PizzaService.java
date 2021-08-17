package com.example.Pizza.service;

import com.example.Pizza.entity.Pizza;
import com.example.Pizza.repository.PizzaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PizzaService {

    private final PizzaRepo pizzaRepo;

    public Iterable<Pizza> getAllPizza() {
        return pizzaRepo.findAll();
    }

    public Iterable<Pizza> saveList(List<Pizza> pizzas) {
        return pizzaRepo.saveAll(pizzas);
    }

}
