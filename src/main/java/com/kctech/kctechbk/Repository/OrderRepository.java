package com.kctech.kctechbk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kctech.kctechbk.Model.Order;



public interface OrderRepository extends JpaRepository<Order, Long>{
    
}