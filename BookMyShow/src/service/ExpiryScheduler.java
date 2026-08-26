package service;

import domain.Show;
import domain.ShowSeat;
import repository.ShowSeatRepository;

import java.util.List;

public class ExpiryScheduler {

    private ShowSeatRepository showSeatRepository;

    public ExpiryScheduler(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }

    public void releaseSeat(){
        List<ShowSeat> list = showSeatRepository.findExpiredSeats();
        for(ShowSeat seat : list){
            seat.release();
        }
    }
}
