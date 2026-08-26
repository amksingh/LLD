package repository;

import domain.ShowSeat;
import domain.ShowSeatStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowSeatRepository {

   Map<Integer, Map<Integer, ShowSeat>> map = new HashMap<>();

    public boolean checkSeatAreAvailableOrNot(int showId, List<ShowSeat> showSeats){
        Map<Integer, ShowSeat> seatMap = map.get(showId);
        if(seatMap == null || seatMap.size() == 0){
            return false;
        }
        for(ShowSeat seat : showSeats){
            if(!seatMap.containsKey(seat.getId()) ||
                    seatMap.get(seat.getId()).getStatus() != ShowSeatStatus.AVAILABLE){
                return false;
            }
        }
        return true;

    }
}
