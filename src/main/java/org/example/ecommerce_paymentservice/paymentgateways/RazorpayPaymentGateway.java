package org.example.ecommerce_paymentservice.paymentgateways;

import com.razorpay.RazorpayClient;
import com.razorpay.PaymentLink;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
@Service
public class RazorpayPaymentGateway implements PaymentGateway{

    private RazorpayClient razorpayClient; //its provide by Razorpay . similar to fakestoreClient in product service

    public RazorpayPaymentGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }
    @Override
    public String generatePaymentLink(String orderId, String email, String phoneNumber, long amount){
        try {
            JSONObject paymentLinkRequest = new JSONObject();

            paymentLinkRequest.put("amount",amount);
            paymentLinkRequest.put("currency","INR");
            paymentLinkRequest.put("accept_partial",false);
            paymentLinkRequest.put("expire_by", 1707815586); // 1 day from now, we can use any date in future, change in epoch time
            paymentLinkRequest.put("reference_id",orderId);
            paymentLinkRequest.put("description","Payment for order #" + orderId);
            JSONObject customer = new JSONObject();
            customer.put("name",phoneNumber);
            customer.put("contact","Nirosha Rayee");
            customer.put("email",email);
            paymentLinkRequest.put("customer",customer);
            JSONObject notify = new JSONObject();
            notify.put("sms",true);
            notify.put("email",true);
            paymentLinkRequest.put("notify",notify);
            paymentLinkRequest.put("reminder_enable",true);
            paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
            paymentLinkRequest.put("callback_method","get");

            PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
            return payment.get("short_url").toString();
        } catch (Exception e) {
            System.out.println(e.toString());
            return "something is wrong";
        }
    }
}
