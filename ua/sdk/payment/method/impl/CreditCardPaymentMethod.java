package ua.sdk.payment.method.impl;

import ua.sdk.payment.method.PaymentMethod;

public class CreditCardPaymentMethod implements PaymentMethod {

    @Override
    public void processPayment() throws RuntimeException {
        if (Math.random() < 0.2) {
            // Some external exception (any type possible)
            throw new RuntimeException("Credit Card payment failed");
        }
        System.out.println("Credit Card payment success");
    }
}
