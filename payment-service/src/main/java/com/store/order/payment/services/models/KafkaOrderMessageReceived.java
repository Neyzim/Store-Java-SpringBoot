package com.store.order.payment.services.models;

import java.time.Instant;

public class KafkaOrderMessageReceived {
    private Long id;
    private Instant instant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }
}
