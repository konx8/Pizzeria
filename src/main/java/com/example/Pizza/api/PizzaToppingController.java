package com.example.Pizza.api;

import com.example.Pizza.entity.Pizza;
import com.example.Pizza.entity.PizzaTopping;
import com.example.Pizza.service.PizzaToppingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PizzaToppingController {

    private PizzaToppingService pizzaToppingService;

    @GetMapping("/PizzaTopping")
    public Iterable<PizzaTopping> getPizzaTopping(){
        return pizzaToppingService.getAllPizzaTopping();
    }

//    @GetMapping("/PizzaToppingList")
//    public Iterable<PizzaTopping> getPizzaToppingList(){
//        return pizzaToppingService.saveListPizzaTopping();
//    }


}


