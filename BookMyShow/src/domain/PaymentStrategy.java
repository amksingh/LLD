package domain;

public interface PaymentStrategy {

    public PaymentStatus pay(Payment payment);
}
