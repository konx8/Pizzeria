package com.example.Pizza.api;

import com.example.Pizza.entity.Drink;
import com.example.Pizza.service.DrinkService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor

public class DrinkController {

    private DrinkService drinkService;

    @GetMapping("/drinks")
    public Iterable<Drink> getDrink(){
        return drinkService.getAllDrinks();
    }

    @GetMapping("/listDrink")
    public Iterable<Drink> listDrink() {
        return drinkService.getAllDrinks();
    }


}
