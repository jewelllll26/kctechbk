package com.kctech.kctechbk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kctech.kctechbk.Model.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

}