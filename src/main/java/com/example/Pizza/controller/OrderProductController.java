package com.example.Pizza.controller;

import com.example.Pizza.entity.OrderProduct;
import com.example.Pizza.service.OrderProductService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@AllArgsConstructor
public class OrderProductController {

    private OrderProductService orderProductService;


    @GetMapping("/getAllOrders")
    public Iterable<OrderProduct> getAllOrderProducts(){
        return orderProductService.getAllOrderProducts();
    }


    @GetMapping("/getCustomerId")
    public Iterable<OrderProduct> getCustomerId(@RequestParam(name = "id") Long id){
        return orderProductService.getByCustomerId(id);
    }

    @PostMapping("/customerOrder")
    public ResponseEntity<Iterable<OrderProduct>> addProductToList(@RequestBody Iterable<OrderProduct> orderProduct,
                                                                   @RequestParam(name = "id") Long id){

        if (orderProductService.existsByOrderId(id)){
            return ResponseEntity.ok(orderProductService.saveProduct(orderProduct,id));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getOrder")
    public List<OrderProduct> findOrderProductByOrderId(@RequestParam(name = "id") Long id){
        return orderProductService.findOrderProductByOrderId(id);
    }

    @GetMapping("/getBill")
    public int getBill(@RequestParam(name = "id") Long id){
        return orderProductService.getBill(id);
    }

    @GetMapping("/sendMail/{email}/{id}")
    public String sendMail(@PathVariable  String email,@PathVariable  Long id) throws MessagingException {
        orderProductService.dataToEmail(email,id);
        return "send";
    }

}
