package com.example.Pizza.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "soup")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Soup {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private int price;

}
