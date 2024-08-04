package ua.sdk.payment.method;

public interface PaymentMethod {

    void processPayment() throws RuntimeException;
}
