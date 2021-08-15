package com.example.Pizza.api;

import com.example.Pizza.entity.Pizza;
import com.example.Pizza.repository.PizzaRepo;
import com.example.Pizza.service.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@AllArgsConstructor

public class PizzaController {

    private final PizzaRepo pizzaRepo;
    private final PizzaService pizzaService;


    @GetMapping("/pizzas")
    public Iterable<Pizza> getPizza(){
       return pizzaRepo.findAll();
    }
    @PostMapping("/pizza")
    public Pizza addPizza(@RequestBody Pizza pizza){
        return pizzaRepo.save(pizza);
    }

    @DeleteMapping("/pizza/{id}")
    public void deletePizza(@PathVariable Long id){
        pizzaRepo.deleteById(id);
    }

    @GetMapping("/list")
    public Iterable<Pizza> list() {
        return pizzaService.list();
    }


}
