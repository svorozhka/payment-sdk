package ua.sdk.payment;

import ua.sdk.payment.method.model.PaymentCode;
import ua.sdk.payment.processor.PaymentProcessor;
import ua.sdk.payment.processor.impl.CommonPaymentProcessor;

public class PaymentTestApp {

    public static void main(String[] args) {
        PaymentProcessor processor = new CommonPaymentProcessor();
        processor.executePayment(PaymentCode.CRYPTO);
        processor.executePayment(PaymentCode.PAY_PAL);
        processor.executePayment(PaymentCode.CREDIT_CARD);
    }
}
