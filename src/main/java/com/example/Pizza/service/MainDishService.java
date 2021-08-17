package com.example.Pizza.service;

import com.example.Pizza.entity.MainDish;
import com.example.Pizza.entity.Pizza;
import com.example.Pizza.repository.MainDishRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MainDishService {

    private MainDishRepo mainDishRepo;

    public Iterable<MainDish> getAllMainDish() {
        return mainDishRepo.findAll();
    }

    public Iterable<MainDish> saveListMainDish(List<MainDish> mainDishes) {
        return mainDishRepo.saveAll(mainDishes);
    }


}
