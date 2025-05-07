package org.example.test.payment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.example.test.payment.PaymentResponse.paymentStatus.*;
import static org.junit.Assert.*;

public class PaymentProcessorTest {
    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setUp() {
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void payment_is_correct() {

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(SUCCESS));


        assertTrue(paymentProcessor.makePayment(10000));
    }

    @Test
    public void payment_is_wrong() {
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(FAILURE));

        assertFalse(paymentProcessor.makePayment(10000));
    }
}