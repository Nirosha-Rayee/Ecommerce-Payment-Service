package org.example.ecommerce_paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitialPaymentDTO {
    private String email;
    private String phoneNumber;
    private Long amount;
    private String orderId;

}
