package com.example.Pizza.api;

import com.example.Pizza.entity.MainDish;
import com.example.Pizza.entity.Pizza;
import com.example.Pizza.service.MainDishService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainDishController {

    private MainDishService mainDishService;

    @GetMapping("/mainDish")
    public Iterable<MainDish> getMainDish(){
        return mainDishService.getAllMainDish();
    }

    //@GetMapping("/mainDishList")
    //public Iterable<MainDish> saveListMainDish(List<MainDish> users) {
    //    return mainDishService.saveListMainDish(users);
    //}


}
