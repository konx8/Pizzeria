package com.example.Pizza.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
