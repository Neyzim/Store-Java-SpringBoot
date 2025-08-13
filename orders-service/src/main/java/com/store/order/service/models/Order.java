package com.store.order.service.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name="Order_Table")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd't'HH:mm:ss'Z'", timezone = "GMT")
    private Instant instant;

    public Order() {
    }

    public Order(Long id, Instant instant) {
        this.id = id;
        this.instant = instant;
    }

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}