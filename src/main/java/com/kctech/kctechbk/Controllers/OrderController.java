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

    @GetMapping("/all")
    public List<Order> getOrders(){
        return repo.findAll();
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new OrderNotFoundException(id));
    }

    @PostMapping("/new")
    public String addOrder(@RequestBody Order newOrder){
        repo.save(newOrder);
        return "A new order is added.";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        repo.deleteById(id);
        return "An order is deleted.";
    }

}