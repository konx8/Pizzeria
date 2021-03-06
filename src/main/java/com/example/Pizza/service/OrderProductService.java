package com.example.Pizza.service;

import com.example.Pizza.entity.Order;
import com.example.Pizza.entity.OrderProduct;
import com.example.Pizza.repository.OrderProductRepo;
import com.example.Pizza.repository.OrderRepo;
import com.example.Pizza.view.OrderProductView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderProductService {

    private OrderProductRepo orderProductRepo;
    private OrderRepo orderRepo;
    private MailService mailService;


    public List<OrderProductView> listOfOrderedProductView(Long orderID){

        List<OrderProduct> orderProductsList = orderProductRepo.findAllOrderProductByOrderID(orderID);
        List<OrderProductView> orderProductViewList = new ArrayList<>();

        for(OrderProduct product:orderProductsList){

            OrderProductView orderProductView = new OrderProductView();

            orderProductView.setId(product.getId());
            orderProductView.setOrderID(product.getOrder().getId());
            orderProductView.setProductID(product.getProduct().getId());
            orderProductView.setQuantity(product.getQuantity());
            orderProductView.setData(product.getData());

            orderProductViewList.add(orderProductView);
        }
        return orderProductViewList;
    }
    public OrderProduct findByLastRecord(){
        return orderProductRepo.findByLastRecord();
    }

    public Iterable<OrderProduct> getAllOrderProducts(){
        return orderProductRepo.findAll();
    }

    public Iterable<OrderProduct> getByCustomerId(Long id){
        return orderProductRepo.findByCustomerId(id);
    }

    public void deleteOrder(Long id ){
        orderProductRepo.deleteById(id);
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

    public OrderProduct saveSingleProduct(OrderProduct orderProduct, Long id){
        OrderProduct orderProduct1 = new OrderProduct();

        Order order = orderRepo.getById(id);
        orderProduct1.setQuantity(orderProduct.getQuantity());
        orderProduct1.setProduct(orderProduct.getProduct());
        orderProduct1.setOrder(order);
        orderProduct1.setData(LocalDateTime.now());
        orderProductRepo.save(orderProduct1);
        return orderProduct1;
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
        productList = "Dzie?? dobry " + "<br>\n" +
                "Id zam??wienia " + id + "<br>\n" +
                "twoje zam??wnie : " + "<br>\n" +
                productList  + "koszt ca??kowity: " + getBill(id);

        mailService.sendMail(email,"Order",productList,true);

    }
}
