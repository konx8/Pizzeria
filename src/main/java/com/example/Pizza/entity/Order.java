package com.example.Pizza.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrderProduct> orderProducts;

    public Order(Customer customer) {
        this.customer = customer;
    }
}
