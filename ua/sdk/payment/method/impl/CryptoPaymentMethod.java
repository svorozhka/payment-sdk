package ua.sdk.payment.method.impl;

import ua.sdk.payment.method.PaymentMethod;

public class CryptoPaymentMethod implements PaymentMethod {

    @Override
    public void processPayment() throws RuntimeException {
        if (Math.random() < 0.2) {
            // Some external exception (any type possible)
            throw new RuntimeException("Crypto payment failed");
        }
        System.out.println("Crypto payment success");
    }
}
