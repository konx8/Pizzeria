package com.example.Pizza;

import com.example.Pizza.api.PizzaController;
import com.example.Pizza.entity.Pizza;
import com.example.Pizza.service.PizzaService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class PizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(PizzaService pizzaService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Pizza>> typeReference = new TypeReference<List<Pizza>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("data.json");
			try {
				List<Pizza> users = mapper.readValue(inputStream,typeReference);
				pizzaService.saveList(users);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}



}
