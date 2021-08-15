package com.example.Pizza.repository;

import com.example.Pizza.entity.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepo extends CrudRepository<Pizza,Long> {
}
