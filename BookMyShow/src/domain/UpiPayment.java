package domain;

public class UpiPayment implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("The payment of amount has been done using upi +"+amount);
    }
}
