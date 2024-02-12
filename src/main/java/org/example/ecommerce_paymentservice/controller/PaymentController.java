package org.example.ecommerce_paymentservice.controller;

import org.example.ecommerce_paymentservice.dtos.InitialPaymentDTO;
import org.example.ecommerce_paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody InitialPaymentDTO request) {
        return paymentService.initiatePayment(request.getOrderId(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getAmount());

    }

}
