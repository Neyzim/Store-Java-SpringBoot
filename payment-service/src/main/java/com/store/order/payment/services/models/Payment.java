package com.store.order.payment.services.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.store.order.payment.services.enums.PaymentEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Document(collection = "payment")
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String payment_id;

    private Instant instant;

    private Integer paymentStatus;

    public Payment() {
    }

    public Payment(String payment_id, Instant instant, PaymentEnum paymentEnum) {
        this.payment_id = payment_id;
        this.instant = instant;
        ApplyPaymentStatus(paymentEnum);
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void ApplyPaymentStatus(PaymentEnum paymentEnum) {
        if (paymentEnum != null) {
            this.paymentStatus = paymentEnum.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(payment_id, payment.payment_id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(payment_id);
    }
}
