package com.example.Pizza;

import com.example.Pizza.api.PizzaController;
import com.example.Pizza.entity.*;
import com.example.Pizza.repository.*;
import com.example.Pizza.service.PizzaService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)

@Component
@AllArgsConstructor
public class DataToDB {

    private PizzaRepo pizzaRepo;
    private DrinkRepo drinkRepo;
    private MainDishRepo mainDishRepo;
    private PizzaToppingRepo pizzaToppingRepo;
    private SideDisheRepo sideDisheRepo;
    private SoupRepo soupRepo;


    @EventListener
    public void fillDB(ApplicationReadyEvent event) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Pizza> pizzaList = objectMapper.readValue(new File("src/main/resources/json/pizzaData.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Pizza.class));
        pizzaRepo.saveAll(pizzaList);

        List<Drink> drinkList = objectMapper.readValue(new File("src/main/resources/json/drinkData.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Drink.class));
        drinkRepo.saveAll(drinkList);

        List<MainDish> mainDishRepoList = objectMapper.readValue(new File("src/main/resources/json/mainDishData.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, MainDish.class));
        mainDishRepo.saveAll(mainDishRepoList);

        List<PizzaTopping> pizzaToppingList = objectMapper.readValue(new File("src/main/resources/json/pizzaToppingData.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, PizzaTopping.class));
        pizzaToppingRepo.saveAll(pizzaToppingList);

        List<SideDishe> sideDisheList = objectMapper.readValue(new File("src/main/resources/json/sideDishData.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, SideDishe.class));
        sideDisheRepo.saveAll(sideDisheList);

        List<Soup> soupList = objectMapper.readValue(new File("src/main/resources/json/soupData.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Soup.class));
        soupRepo.saveAll(soupList);


    }
}
