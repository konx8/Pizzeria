package com.example.Pizza.repository;

import com.example.Pizza.entity.Drink;
import com.example.Pizza.entity.Soup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoupRepo extends CrudRepository<Soup,Long> {
}
