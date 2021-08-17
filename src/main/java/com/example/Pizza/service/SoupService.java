package com.example.Pizza.service;

import com.example.Pizza.entity.Pizza;
import com.example.Pizza.entity.Soup;
import com.example.Pizza.repository.SoupRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
@AllArgsConstructor
public class SoupService {

    private SoupRepo soupRepo;


    public Iterable<Soup> getAllSoup() {
        return soupRepo.findAll();
    }

    public Iterable<Soup> saveListSoup(List<Soup> soups) {
        return soupRepo.saveAll(soups);
    }


}
