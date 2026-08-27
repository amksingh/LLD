package domain;

public class UpiPayment implements PaymentStrategy{
    @Override
    public PaymentStatus pay(Payment payment) {
        System.out.println("The payment of amount has been done using upi +"+payment.getAmount());
        return PaymentStatus.COMPLETED;
    }
}
