package com.kctech.kctechbk.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kctech.kctechbk.Model.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}