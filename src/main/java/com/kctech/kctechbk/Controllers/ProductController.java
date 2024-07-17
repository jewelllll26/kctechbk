package com.kctech.kctechbk.Controllers;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kctech.kctechbk.Model.Product;
import com.kctech.kctechbk.Repository.ProductRepository;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    ProductRepository repo;


    public ProductController(ProductRepository repo) {
        this.repo = repo;
    } 
    }

    //http://127.0.0.1/products
    //Get all products
    @GetMapping("/products")
    public List<Product> getProducts(){
    // http://127.0.0.1/products
    // Get all products
    @GetMapping("/all")
    public List<Product> getProducts() {
        return repo.findAll();
    }

    //http:127.0.0.1:8080/product/2
    @GetMapping("/product/{id}")
    public Product geProduct(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new ProductNotFoundException(id));
    // http://127.0.0.1:8080/product/2
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(
                () -> new ProductNotFoundException(id));
    }
    //http:127.0.0.1:8080/product/new
    @PostMapping("/product/new")
    public String addProduct(@RequestBody Product newProduct){

    // http://127.0.0.1:8080/product/new
    @PostMapping("/new")
    public String addProduct(@RequestBody Product newProduct) {
        repo.save(newProduct);
        return "A new product is added.";
        return "A new product is added. Yey!";

    }

    //UPDATE END POINTS
    //http://127.0.0.1:8080/product/edit/1
    @PutMapping("/product/edit/{id}")
    public Product updateProduct(@PathVariable Long id,
    @RequestBody Product newProduct){

    // UPDATE ENDPOINTS
    // http://127.0.0.1:8080/product/edit/1
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product newProduct) {
        return repo.findById(id)
        .map(product ->{
            product.setProductName(newProduct.getProductName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            return repo.save(product);
        }).orElseGet(()->{
            return repo.save(newProduct);
        });
                .map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setDescription(newProduct.getDescription());
                    product.setPrice(newProduct.getPrice());
                    return repo.save(product);
                }).orElseGet(() -> {
                    return repo.save(newProduct);
                });

    }

    //DELETE ENDPOINTS
    //http://127.0.0.1:8080/product/delete/1
    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
    // DELETE ENDPOINTS
    // http:127.0.0.1:8080/product/delete/1
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        repo.deleteById(id);
        return "A product is deleted!";
    }
}