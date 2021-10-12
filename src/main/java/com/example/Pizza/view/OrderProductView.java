package com.example.Pizza.view;

import com.example.Pizza.entity.Order;
import com.example.Pizza.entity.OrderProduct;
import com.example.Pizza.repository.OrderProductRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class OrderProductView {


    public Long id;
    public Long orderID;
    public int productID;
    public int quantity;
    public LocalDateTime data;


}
