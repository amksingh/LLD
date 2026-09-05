package domain;

public interface PaymentStrategy {

    public PaymentStatus pay(Payment payment);
    public PaymentStatus refund(Payment payment);
}
