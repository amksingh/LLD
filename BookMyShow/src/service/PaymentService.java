package service;

import domain.PaymentStatus;
import domain.PaymentStrategy;

public class PaymentService {

    private PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {

        this.paymentStrategy = paymentStrategy;
    }

    public PaymentStatus pay(int amount){
        paymentStrategy.pay(amount);
        return  PaymentStatus.COMPLETED;
    }
}
