package com.example.Pizza.api;

import com.example.Pizza.entity.Pizza;
import com.example.Pizza.entity.Soup;
import com.example.Pizza.service.SoupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SoupController {

    private SoupService soupService;

    @GetMapping("/soups")
    public Iterable<Soup> getPizza(){
        return soupService.getAllSoup();
    }

}
