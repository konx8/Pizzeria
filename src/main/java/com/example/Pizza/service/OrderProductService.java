package com.example.Pizza.service;

import com.example.Pizza.entity.Order;
import com.example.Pizza.entity.OrderProduct;
import com.example.Pizza.repository.OrderProductRepo;
import com.example.Pizza.repository.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;



@Service
@AllArgsConstructor
public class OrderProductService {

    private OrderProductRepo orderProductRepo;
    private OrderRepo orderRepo;

    private MailService mailService;

    public Iterable<OrderProduct> getAllOrderProducts(){
        return orderProductRepo.findAll();
    }


//    public Optional<OrderProduct> findByOrderId(Long id){
//        return orderProductRepo.findByOrderId(id);
//    }

    public Iterable<OrderProduct> getByCustomerId(Long id){
        return orderProductRepo.findByCustomerId(id);
    }

/////////////////////////////////////////////////////////////////


    public Iterable<OrderProduct> saveProduct(Iterable<OrderProduct> orderProduct, Long id){
        Order order = orderRepo.getById(id);

        for(OrderProduct orderP:orderProduct){
            orderP.setOrder(order);
            orderP.setData(LocalDateTime.now());


        }

        return orderProductRepo.saveAll(orderProduct);

    }


    public boolean existsByOrderId(Long id) {
        return orderRepo.existsById(id);

    }

    public List<OrderProduct> findOrderProductByOrderId(Long id){
        return orderProductRepo.findByOrderId(id);


    }


    public int getBill(Long id){
        List<OrderProduct> orderProduct = orderProductRepo.findByOrderId(id);
        int totalPrice = 0;

        for(OrderProduct list:orderProduct){
            int quantity = list.getQuantity();
            int price = list.getProduct().getPrice();
            int sum = quantity * price;
            totalPrice = totalPrice+ sum;
        }
        return totalPrice;

    }



    /////////////////// EMAIL ////////////////////


    public void dataToEmail(String email,Long id) throws MessagingException {
        List<OrderProduct> orderProduct = orderProductRepo.findByOrderId(id);
        String productList = ("");
        for(OrderProduct product:orderProduct){
            String name = product.getProduct().getName();
            int quantity = product.getQuantity();
            productList = productList + name + " " +quantity + ", " + "<br>\n" ;
        }
        productList = "Dzień dobry " + "<br>\n" +
                "Id zamówienia " + id + "<br>\n" +
                "twoje zamównie : " + "<br>\n" +
                productList  + "koszt całkowity: " + getBill(id);

        mailService.sendMail(email,"Order",productList,true);

    }

}
