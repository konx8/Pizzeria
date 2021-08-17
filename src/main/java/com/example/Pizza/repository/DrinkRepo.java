package com.example.Pizza.repository;

import com.example.Pizza.entity.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepo extends CrudRepository<Drink,Long> {
}
