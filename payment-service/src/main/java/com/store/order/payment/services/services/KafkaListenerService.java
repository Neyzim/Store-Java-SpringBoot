package com.store.order.payment.services.services;

import com.store.order.payment.services.models.KafkaOrderMessageReceived;
import com.store.order.payment.services.models.Payment;
import com.store.order.payment.services.repositories.PaymentRepository;
import org.bson.types.ObjectId;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class KafkaListenerService {

    private final PaymentService paymentService;

    public KafkaListenerService (PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @KafkaListener(topics = "Order_send_ok", groupId = "Order-Received")
    public void messageReceived(KafkaOrderMessageReceived orderMessageReceived){
        Payment payment = new Payment();
        payment.setPayment_id(new ObjectId().toString());  //
        payment.setInstant(Instant.now());
        payment.setPaymentStatus(1);
        payment.setOrderId(String.valueOf(orderMessageReceived.getId()));
        paymentService.save(payment);
        System.out.println("Mensagem recebida: " + orderMessageReceived);
    }
}

