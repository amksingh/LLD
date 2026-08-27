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
        PaymentStatus status = paymentStrategy.pay(payment);
        if(status == PaymentStatus.COMPLETED){
            payment.complete();
        }else{
            payment.failed();
        }
        return status;
    }
}
