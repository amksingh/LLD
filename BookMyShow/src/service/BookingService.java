package service;

import domain.*;
import repository.BookingRepository;
import repository.PaymentRepository;
import repository.ShowSeatRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class BookingService {

    private BookingRepository bookingRepository;
    private ShowSeatRepository showSeatRepository;
    private PaymentService paymentService;
    private PaymentRepository paymentRepository;

    public BookingService(BookingRepository bookingRepository, ShowSeatRepository showSeatRepository) {
        this.bookingRepository = bookingRepository;
        this.showSeatRepository = showSeatRepository;
    }

    public Booking bookTicket(User user, Show show, List<ShowSeat> showSeats){
        boolean reserved = showSeatRepository.reserveSeats(show.getId(), showSeats);
        if(!reserved){
            throw new IllegalStateException("One or more seat are not available");
        }
        Booking booking = new Booking(0, user, showSeats);
        booking.processing();
        int amount = booking.getAmount();
        try {
            bookingRepository.save(booking);
            Payment payment = new Payment(0, booking.getId(), amount);
            PaymentStatus status = paymentService.pay(payment);
            if(status == PaymentStatus.COMPLETED){
                booking.completed();
                bookingRepository.save(booking);
                paymentRepository.save(payment);
                for(ShowSeat seat : showSeats){
                    seat.confirm();
                    showSeatRepository.save(show, seat);
                }
                return  booking;
            }else{
                booking.failed();
                bookingRepository.save(booking);
                throw new IllegalStateException("Payment to the booking got failed");
            }

        }catch (Exception e){
            showSeatRepository.releaseSeats(show.getId(), showSeats);
            throw e;
        }
    }
}
