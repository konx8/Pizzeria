package com.example.Pizza.service;

import com.example.Pizza.entity.Pizza;
import com.example.Pizza.repository.PizzaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepo pizzaRepo;

    public PizzaService(PizzaRepo pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    public Iterable<Pizza> list() {
        return pizzaRepo.findAll();
    }

    public Iterable<Pizza> saveList(List<Pizza> users) {
        return pizzaRepo.saveAll(users);
    }

}
