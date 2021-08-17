package com.example.Pizza.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pizza")
@JsonInclude(JsonInclude.Include.NON_NULL)


public class Pizza {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private int price;

    @OneToMany(mappedBy = "pizza",
    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PizzaOrder> pizzaOrders;


}
