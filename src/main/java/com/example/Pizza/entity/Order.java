package com.example.Pizza.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    //private String orderName;

    public void setProduct(Class type){

        if(type.toString().equals(Pizza.class.toString())){
            List<Pizza> pizza;
        }
        if(type.equals(Drink.class)){
            List<Drink> Drink;
        }

    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<PizzaOrder> pizzaOrders;



}
