package repository;

import domain.Payment;

import java.util.HashMap;
import java.util.Map;

public class PaymentRepository {
    Map<Integer, Payment> map = new HashMap<>();
    int nextId = 1;

    public void save(Payment payment) {
        if(payment.getId() == 0){
            map.put(nextId++, payment);
        }else{
            map.put(payment.getId(), payment);
        }

    }
}
