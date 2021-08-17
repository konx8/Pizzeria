package com.example.Pizza.service;

import com.example.Pizza.entity.Drink;
import com.example.Pizza.repository.DrinkRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DrinkService {

    private DrinkRepo drinkRepo;

    public Iterable<Drink> getAllDrinks() {
        return drinkRepo.findAll();
    }

    public Iterable<Drink> saveListDrinks(List<Drink> drinks) {
        return drinkRepo.saveAll(drinks);
    }



}
