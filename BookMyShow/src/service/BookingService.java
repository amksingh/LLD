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

    public BookingService(BookingRepository bookingRepository, ShowSeatRepository showSeatRepository, PaymentService paymentService, PaymentRepository paymentRepository) {
        this.bookingRepository = bookingRepository;
        this.showSeatRepository = showSeatRepository;
        this.paymentService = paymentService;
        this.paymentRepository = paymentRepository;
    }

    public Booking bookTicket(User user, Show show, List<ShowSeat> showSeats){
        boolean reserved = showSeatRepository.reserveSeats(show.getId(), showSeats);
        if(!reserved){
            throw new IllegalStateException("One or more seat are not available");
        }
        Booking booking = new Booking(0, user, showSeats);
        int amount = booking.getAmount();
        try {
            bookingRepository.save(booking);
            Payment payment = new Payment(0, booking.getId(), amount);
            PaymentStatus status = paymentService.pay(payment);
            paymentRepository.save(payment);
            if(status == PaymentStatus.COMPLETED){
                boolean isConfirmedAll = showSeatRepository.confirmSeats(show, showSeats);
                if(!isConfirmedAll){
                    paymentService.refund(payment);
                    paymentRepository.save(payment);
                    booking.failed();
                    bookingRepository.save(booking);
                    showSeatRepository.releaseSeats(show.getId(), showSeats);
                    return booking;
                }
                booking.completed();
                bookingRepository.save(booking);

                return  booking;
            }else{
                booking.failed();
                bookingRepository.save(booking);
                showSeatRepository.releaseSeats(show.getId(), showSeats);
                return booking;
            }

        }catch (Exception e){
            showSeatRepository.releaseSeats(show.getId(), showSeats);
            throw e;
        }
    }
}
