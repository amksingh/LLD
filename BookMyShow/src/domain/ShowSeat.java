package domain;

public class ShowSeat {

    private int id;
    private Seat seat;
    private Show show;
    private ShowSeatStatus status;
    private int price;

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
    }

    public void confirm(){
        if(this.status != ShowSeatStatus.HELD){
            throw new IllegalStateException("The seat cannot be booked");
        }
        this.status = ShowSeatStatus.BOOKED;
    }

    public void release(){
        if(this.status != ShowSeatStatus.HELD){
            throw new IllegalStateException("The seat cannot be booked");
        }
        this.status = ShowSeatStatus.AVAILABLE;
    }

    public  boolean isAvailable(){
        return this.status == ShowSeatStatus.AVAILABLE;
    }
}
