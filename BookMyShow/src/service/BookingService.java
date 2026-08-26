package service;

import domain.Booking;
import domain.Show;
import domain.ShowSeat;
import domain.User;
import repository.BookingRepository;
import repository.ShowSeatRepository;

import java.util.List;

public class BookingService {

    private BookingRepository bookingRepository;
    private ShowSeatRepository showSeatRepository;

    public BookingService(BookingRepository bookingRepository, ShowSeatRepository showSeatRepository) {
        this.bookingRepository = bookingRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public Booking bookTicket(User user, Show show, List<ShowSeat> showSeats){
        if(!showSeatRepository.checkSeatAreAvailableOrNot(show.getId(), showSeats)){
            throw new RuntimeException("Selected seats are not availabe" +
                    "could not complete booking");
        }
        for(ShowSeat seat : showSeats){
            seat.hold();
        }
        Booking booking = new Booking(0, user, showSeats);
        int amount = booking.getAmount();

        booking = bookingRepository.save(booking);
        return booking;
    }
}
