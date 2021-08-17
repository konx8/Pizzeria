package com.example.Pizza.api;

import com.example.Pizza.entity.Pizza;
import com.example.Pizza.entity.SideDishe;
import com.example.Pizza.service.SideDisheService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SideDisheController {

    private SideDisheService sideDisheService;

    @GetMapping("/SideDishes")
    public Iterable<SideDishe> getPizza(){
        return sideDisheService.getAllSideDish();
    }

}
