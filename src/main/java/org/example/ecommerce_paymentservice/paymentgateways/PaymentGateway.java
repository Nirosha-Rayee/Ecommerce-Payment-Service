package org.example.ecommerce_paymentservice.paymentgateways;

public interface PaymentGateway {
    String generatePaymentLink(String orderId, String email, String phoneNumber, long amount);
}
