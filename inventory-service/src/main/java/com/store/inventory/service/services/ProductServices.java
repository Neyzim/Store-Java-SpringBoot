package com.store.inventory.service.services;

import com.store.inventory.service.models.Product;
import com.store.inventory.service.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {


    @Autowired
    private ProductRepository productRepository;


    public List<Product> findAll(){
        return productRepository.findAll();

    }

    public Product findById(Long id){
        Optional<Product> product_list = productRepository.findById(id);
        return product_list.get();
    }
}
