package org.example.ecommerce_paymentservice.services;

import org.example.ecommerce_paymentservice.paymentgateways.PaymentGateway;
import org.example.ecommerce_paymentservice.paymentgateways.PaymentGatewayStrategyChooser;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGatewayStrategyChooser paymentGatewayChooserStrategy;

    public PaymentService(PaymentGatewayStrategyChooser paymentGatewayChooserStrategy) {
        this.paymentGatewayChooserStrategy = paymentGatewayChooserStrategy;
    }

    public String initiatePayment(String orderId, String email, String phoneNumber, Long amount) {
        // when we are initializing the payment, we need to get the order details and then get the amount to be paid
        // from the orderId, we go to order service to get the order details
        // code is below

        // Order order = orderService.getOrderDetails(orderId)
        // Long amount = order.getAmount();
        // double amount = 10.10; // store number * 100
        // String orderId, String email, String phoneNumber, Long amount
       // Long amount = 1010L; // 10.00 => 1000

        //But we are not integrating with order service, so we will get these details from the API request itself but ideally we should get it from order service.

        PaymentGateway paymentGateway =
                paymentGatewayChooserStrategy.getBestPaymentGateway();

        return paymentGateway.generatePaymentLink(orderId, email, phoneNumber, amount);
    }
}
