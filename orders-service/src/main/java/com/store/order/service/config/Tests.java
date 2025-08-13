package com.store.order.service.config;

import com.store.order.service.models.Order;
import com.store.order.service.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;

@Configuration
@Profile("postgres")
public class Tests implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"));
        orderRepository.save(o1);
    }
}
