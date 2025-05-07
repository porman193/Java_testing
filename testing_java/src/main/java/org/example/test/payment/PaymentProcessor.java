package org.example.test.payment;

import static org.example.test.payment.PaymentResponse.paymentStatus.*;

public class PaymentProcessor {
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount){
        PaymentResponse paymentResponse = paymentGateway.requestPayment(new PaymentRequest(amount));
        if (paymentResponse.getStatus() == SUCCESS) {
            return true;
        }
        return  false;
    }


}
