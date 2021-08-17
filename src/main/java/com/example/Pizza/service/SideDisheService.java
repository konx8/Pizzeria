package com.example.Pizza.service;

import com.example.Pizza.entity.Pizza;
import com.example.Pizza.entity.SideDishe;
import com.example.Pizza.repository.SideDisheRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
@AllArgsConstructor
public class SideDisheService {

    private SideDisheRepo sideDisheRepo;

    public Iterable<SideDishe> getAllSideDish() {
        return sideDisheRepo.findAll();
    }

    public Iterable<SideDishe> saveListSideDishe(List<SideDishe> sideDishes) {
        return sideDisheRepo.saveAll(sideDishes);
    }


}
