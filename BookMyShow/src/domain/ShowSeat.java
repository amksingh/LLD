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

    public void setStatus(ShowSeatStatus status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
