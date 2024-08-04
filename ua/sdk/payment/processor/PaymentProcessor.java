package ua.sdk.payment.processor;

import ua.sdk.payment.method.model.PaymentCode;

public interface PaymentProcessor {

    void executePayment(PaymentCode paymentCode);
}
