package com.example.Pizza;

import com.example.Pizza.entity.*;
import com.example.Pizza.repository.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
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

    private ProductRepo productRepo;

    @EventListener
    public void fillDB(ApplicationReadyEvent event) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> productList = objectMapper.readValue(new File("src/main/resources/json/data.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        productRepo.saveAll(productList);

    }
}
