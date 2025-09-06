//KafkaProducerService

package com.store.order.service.services;

import com.store.order.service.models.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {


    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic.order}")
    private String topic;


    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderMessage(Order order){
        kafkaTemplate.send(topic, order);
    }
}
