package com.store.order.service.controllers;

import com.store.order.service.models.Order;
import com.store.order.service.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderServices orderservices;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orders_list = orderservices.findAll();
        return ResponseEntity.ok().body(orders_list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order_by_id = orderservices.findById(id);
        return ResponseEntity.ok().body(order_by_id);
    }
}
