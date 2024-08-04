package ua.sdk.payment.processor.impl;

import ua.sdk.payment.exception.PaymentException;
import ua.sdk.payment.method.PaymentMethod;
import ua.sdk.payment.method.model.PaymentCode;
import ua.sdk.payment.processor.PaymentProcessor;
import ua.sdk.payment.utils.PaymentMethods;

import java.util.function.Consumer;
import java.util.function.Function;

public class CommonPaymentProcessor implements PaymentProcessor {

    private final Function<PaymentCode, PaymentMethod> getPaymentMethod;
    private final Consumer<? super RuntimeException> handleException;

    public CommonPaymentProcessor() {
        this.getPaymentMethod = PaymentMethods::getPaymentMethod;
        this.handleException = e -> {
            System.err.println(e.getMessage());
            throw new PaymentException("SDK Payment processing exception", e);
        };
    }

    public CommonPaymentProcessor(Function<PaymentCode, PaymentMethod> getPaymentMethod) {
        this.getPaymentMethod = getPaymentMethod;
        this.handleException = e -> {
            System.err.println(e.getMessage());
            throw new PaymentException("SDK Payment processing exception", e);
        };
    }

    public CommonPaymentProcessor(Consumer<? super RuntimeException> handleException) {
        this.getPaymentMethod = PaymentMethods::getPaymentMethod;
        this.handleException = handleException;
    }

    public CommonPaymentProcessor(Function<PaymentCode, PaymentMethod> getPaymentMethod,
                                  Consumer<? super RuntimeException> handleException) {
        this.getPaymentMethod = getPaymentMethod;
        this.handleException = handleException;
    }

    @Override
    public void executePayment(PaymentCode paymentCode) {
        try {
            getPaymentMethod
                    .apply(paymentCode)
                    .processPayment();
        } catch (RuntimeException e) {
            handleException.accept(e);
        }
    }
}
