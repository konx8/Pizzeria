package com.example.Pizza.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@PropertySource(value = "classpath:data.json")
@ConfigurationProperties

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pizza")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pizza {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    private String name;
    private String price;


    @OneToMany(mappedBy = "pizza",
    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PizzaOrder> pizzaOrders;





}
