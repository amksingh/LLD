package service;

import domain.Booking;
import domain.Show;
import domain.ShowSeat;
import domain.User;
import repository.BookingRepository;
import repository.ShowSeatRepository;

public class BookingService {

    private BookingRepository bookingRepository;
    private ShowSeatRepository showSeatRepository;

    public BookingService(BookingRepository bookingRepository, ShowSeatRepository showSeatRepository) {
        this.bookingRepository = bookingRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public Booking bookTicket(User user, Show show, ShowSeat showSeat){
        return null;
    }
}
