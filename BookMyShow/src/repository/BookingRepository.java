package repository;

import domain.Booking;
import domain.ShowSeat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingRepository {

    Map<Integer, Booking> map = new HashMap<>();
    int nextId = 1;
    public Booking save(Booking booking) {
        if(booking.getId() == 0){
            booking.setId(nextId++);
        }
        map.put(booking.getId(), booking);
        return booking;

    }


}
