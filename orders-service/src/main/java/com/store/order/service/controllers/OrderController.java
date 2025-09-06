package com.store.order.service.controllers;

import org.springframework.kafka.support.serializer.JsonSerializer;
import com.store.order.service.models.Order;
import com.store.order.service.services.KafkaProducerService;
import com.store.order.service.services.OrderServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderServices orderServices;
    private final KafkaProducerService kafkaProducerService;

    public OrderController(OrderServices orderServices, KafkaProducerService kafkaProducerService) {
        this.orderServices = orderServices;
        this.kafkaProducerService = kafkaProducerService;
    }


    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orders_list = orderServices.findAll();
        return ResponseEntity.ok().body(orders_list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order_by_id = orderServices.findById(id);
        return ResponseEntity.ok().body(order_by_id);
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendOrder(@RequestBody Order order){
        Order savedOrder = orderServices.save(order);
        kafkaProducerService.sendOrderMessage(savedOrder);
        return ResponseEntity.ok("Order sended to Kafka");
    }
}
