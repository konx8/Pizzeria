package com.example.Pizza.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;


}
