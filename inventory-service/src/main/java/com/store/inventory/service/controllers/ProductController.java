package com.store.inventory.service.controllers;

import com.store.inventory.service.models.Product;
import com.store.inventory.service.repositories.ProductRepository;
import com.store.inventory.service.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory/products")
public class ProductController {

    @Autowired
    ProductServices productServices;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> all_products = productServices.findAll();
        return ResponseEntity.ok().body(all_products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = productServices.findById(id);
        return ResponseEntity.ok().body(product);
    }




}
