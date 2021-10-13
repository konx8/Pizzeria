package com.example.Pizza.view;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;


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
