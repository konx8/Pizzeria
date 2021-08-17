package com.example.Pizza.repository;

import com.example.Pizza.entity.Drink;
import com.example.Pizza.entity.MainDish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainDishRepo  extends CrudRepository<MainDish,Long> {
}
