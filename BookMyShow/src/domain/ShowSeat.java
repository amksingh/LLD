package domain;

import java.time.LocalDateTime;

public class ShowSeat {

    private int id;
    private Seat seat;
    private Show show;
    private ShowSeatStatus status;
    private int price;
    private LocalDateTime holdExpiredAt;

    public ShowSeat(int id, Seat seat, Show show, ShowSeatStatus status, int price) {
        this.id = id;
        this.seat = seat;
        this.show = show;
        this.status = status;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public ShowSeatStatus getStatus() {
        return status;
    }

    public int getPrice() {
        return price;
    }

    public void hold(){
        if(this.status != ShowSeatStatus.AVAILABLE){
            throw new IllegalStateException("The seat is not available");
        }
        this.status = ShowSeatStatus.HELD;
        this.holdExpiredAt = LocalDateTime.now().plusMinutes(5);
    }

    public synchronized  void confirm(){
        if(this.status != ShowSeatStatus.HELD){
            throw new IllegalStateException("The seat cannot be booked");
        }
        this.status = ShowSeatStatus.BOOKED;
    }

    public synchronized  void release(){
        if(this.status != ShowSeatStatus.HELD){
            throw new IllegalStateException("Only the held seat can be released");
        }
        this.status = ShowSeatStatus.AVAILABLE;
    }

    public  boolean isAvailable(){
        return this.status == ShowSeatStatus.AVAILABLE;
    }

    public boolean isHoldExpired(){
        return holdExpiredAt != null && holdExpiredAt.isBefore(LocalDateTime.now()) && this.status == ShowSeatStatus.HELD;
    }
}
