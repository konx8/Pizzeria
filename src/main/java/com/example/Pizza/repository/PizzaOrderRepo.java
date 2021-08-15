package com.example.Pizza.repository;

import com.example.Pizza.entity.PizzaOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaOrderRepo extends CrudRepository<PizzaOrder, Long> {
}
