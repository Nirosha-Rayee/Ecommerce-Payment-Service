package org.example.ecommerce_paymentservice.paymentgateways;

import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class PaymentGatewayStrategyChooser {
    private RazorpayPaymentGateway razorpayPaymentGateway;
    private StripePaymentGateway stripePaymentGateway;

    public PaymentGatewayStrategyChooser(RazorpayPaymentGateway razorpayPaymentGateway, StripePaymentGateway stripePaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public PaymentGateway getBestPaymentGateway() {//here we are choosing initially to return razorpayPaymentGateway
//        int randomInt = new Random().nextInt();
//
//        if (randomInt % 2 == 0) {
//            return razorpayPaymentGateway;
//        }
//
//        return stripePaymentGateway;
        //return razorpayPaymentGateway;
        return stripePaymentGateway;
    }
}











