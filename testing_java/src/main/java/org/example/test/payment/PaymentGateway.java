package org.example.test.payment;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest paymentRequest);
}
