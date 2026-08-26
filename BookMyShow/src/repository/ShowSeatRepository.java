package repository;

import domain.Show;
import domain.ShowSeat;
import domain.ShowSeatStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowSeatRepository {

   Map<Integer, Map<Integer, ShowSeat>> map = new HashMap<>();

    public  synchronized  boolean reserveSeats(int id, List<ShowSeat> showSeats) {
        if(!map.containsKey(id)){
            System.out.println("The particular show is not present");
            return false;
        }
        Map<Integer, ShowSeat> list = map.get(id);
        boolean isAvailable = true;
        for(ShowSeat seat : showSeats){
            if(!list.get(seat.getSeat().getId()).isAvailable()){
                isAvailable = false;
                break;
            }
        }
        if(!isAvailable){
            return false;
        }
        for(ShowSeat seats : showSeats){
            seats.hold();
        }
        return true;
    }
}
