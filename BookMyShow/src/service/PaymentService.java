package service;

import domain.Payment;
import domain.PaymentStatus;
import domain.PaymentStrategy;

public class PaymentService {

    private PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {

        this.paymentStrategy = paymentStrategy;
    }

    public PaymentStatus pay(Payment payment){
        return paymentStrategy.pay(payment);

    }
}
