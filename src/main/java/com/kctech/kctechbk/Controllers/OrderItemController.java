package com.kctech.kctechbk.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kctech.kctechbk.Model.OrderItem;
import com.kctech.kctechbk.NotFoundException.OrderItemNotFoundException;
import com.kctech.kctechbk.Repository.OrderItemRepository;



@RestController
public class OrderItemController {
    OrderItemRepository repo;

   
    public OrderItemController(OrderItemRepository repo) {
        this.repo = repo;
    } 

    //http://127.0.0.1/orderItem
    //Get all orderItem
    @GetMapping("/orderitem")
    public List<OrderItem> getOrderItem(){
        return repo.findAll();
    }

    //http:127.0.0.1:8080/order/2
    @GetMapping("/orderItem/{id}")
    public OrderItem getOrderItem(@PathVariable Long id){
        return repo.findById(id).orElseThrow(
            ()-> new OrderItemNotFoundException(id));
    }
    //http:127.0.0.1:8080/order/new
    @PostMapping("/order/new")
    public String addOrder(@RequestBody OrderItem newOrder){
        repo.save(newOrder);
        return "A new product is added.";
    }
    
    //DELETE ENDPOINTS
    //http://127.0.0.1:8080/order/delete/1
    @DeleteMapping("/order/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        repo.deleteById(id);
        return "A product is deleted!";
    }

}
