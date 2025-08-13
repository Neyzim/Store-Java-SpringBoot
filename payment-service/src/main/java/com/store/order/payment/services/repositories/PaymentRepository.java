package com.store.order.payment.services.repositories;

import com.store.order.payment.services.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
