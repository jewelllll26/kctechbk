package com.kctech.kctechbk.Controllers;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kctech.kctechbk.Model.Order;
import com.kctech.kctechbk.NotFoundException.OrderNotFoundException;
import com.kctech.kctechbk.Repository.OrderRepository;


@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    OrderRepository repo;

   
    public OrderController(OrderRepository repo) {
        this.repo = repo;
    } 
    //http://127.0.0.1/order
    //Get all order
    @GetMapping("/order")
    public List<Order> getOrder(){
        return repo.findAll();
    }
    //http:127.0.0.1:8080/order/2
    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable Long id){
        return repo.findById(id).orElseThrow(
            ()-> new OrderNotFoundException(id));
    }
    //http:127.0.0.1:8080/order/new
    @PostMapping("/order/new")
    public String addOrder(@RequestBody Order newOrder){
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