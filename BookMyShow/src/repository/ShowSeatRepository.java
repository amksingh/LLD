package repository;

import domain.Show;
import domain.ShowSeat;
import domain.ShowSeatStatus;

import java.util.ArrayList;
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
            ShowSeat storedSeat = map.get(id).get(seats.getSeat().getId());
            if(storedSeat == null){
                throw new IllegalArgumentException("Invalid seat selected");
            }
            storedSeat.hold();
        }
        return true;
    }

    public void releaseSeats(int id, List<ShowSeat> showSeats) {
        for(ShowSeat seats : showSeats) {
            ShowSeat storedSeat = map.get(id).get(seats.getSeat().getId());
            if (storedSeat == null) {
                throw new IllegalArgumentException("Invalid seat selected");
            }
            storedSeat.release();
        }
    }

    public List<ShowSeat> findExpiredSeats() {
        List<ShowSeat> list = new ArrayList<>();
        for(Map.Entry<Integer, Map<Integer, ShowSeat>> entry : map.entrySet()){
            Map<Integer, ShowSeat> showSeatMap = entry.getValue();
            for(Map.Entry<Integer, ShowSeat> seatEntry : showSeatMap.entrySet()){
                ShowSeat showSeat = seatEntry.getValue();
                if(showSeat.isHoldExpired()){
                    list.add(showSeat);
                }
            }
        }
        return list;
    }
}
