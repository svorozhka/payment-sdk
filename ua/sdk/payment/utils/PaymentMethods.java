package ua.sdk.payment.utils;

import ua.sdk.payment.method.PaymentMethod;
import ua.sdk.payment.method.impl.CreditCardPaymentMethod;
import ua.sdk.payment.method.impl.CryptoPaymentMethod;
import ua.sdk.payment.method.impl.PayPalPaymentMethod;
import ua.sdk.payment.method.model.PaymentCode;

import java.util.Map;

public class PaymentMethods {

    private static final Map<PaymentCode, PaymentMethod> CODE_TO_PAYMENT_METHOD =
            Map.of(
                   PaymentCode.CRYPTO, new CryptoPaymentMethod(),
                   PaymentCode.CREDIT_CARD, new CreditCardPaymentMethod(),
                   PaymentCode.PAY_PAL, new PayPalPaymentMethod()
            );

    public static PaymentMethod getPaymentMethod(PaymentCode paymentCode) {
        return CODE_TO_PAYMENT_METHOD.get(paymentCode);
    }
}
