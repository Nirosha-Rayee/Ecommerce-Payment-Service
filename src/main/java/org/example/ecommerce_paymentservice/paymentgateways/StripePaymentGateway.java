package org.example.ecommerce_paymentservice.paymentgateways;

import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentGateway{
    @Override
    public String generatePaymentLink(String orderId, String email, String phoneNumber, long amount) {
        return null;
    }
}
