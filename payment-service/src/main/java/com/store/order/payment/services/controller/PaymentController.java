package com.store.order.payment.services.controller;

import com.store.order.payment.services.models.Payment;
import com.store.order.payment.services.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> findById(@PathVariable String id){
        Payment payment = paymentService.findById(id);
        return ResponseEntity.ok().body(payment);
    }

    @PostMapping
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment){
        Payment savedPayment = paymentService.save(payment);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPayment.getPayment_id())
                .toUri();
        return ResponseEntity.created(location).body(savedPayment);
    }
}
