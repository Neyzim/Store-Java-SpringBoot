package com.store.order.payment.services.enums;

public enum PaymentEnum {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private final int code;

    PaymentEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static PaymentEnum fromCode(int code) {
        for (PaymentEnum status : PaymentEnum.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid PaymentEnum code: " + code);
    }
}
