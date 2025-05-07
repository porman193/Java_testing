package org.example.test.payment;

public class PaymentResponse {
    public enum  paymentStatus {
        SUCCESS,
        FAILURE
    }
    private paymentStatus status;

    public PaymentResponse(paymentStatus status) {
        this.status = status;
    }

    public paymentStatus getStatus() {
        return status;
    }
}
