package com.store.order.payment.services.services;

import com.store.order.payment.services.enums.PaymentEnum;
import com.store.order.payment.services.models.Payment;
import com.store.order.payment.services.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment findById(String id){
        Optional<Payment> payment_list = paymentRepository.findById(id);
        return payment_list.orElse(null);
    }
    }

