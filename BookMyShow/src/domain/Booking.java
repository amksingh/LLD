package domain;

import java.util.List;

public class Booking {

    private int id;
    private User user;
    private List<ShowSeat> showSeatList;
    private BookingStatus status;
    private int amount;

    public Booking(int id, User user, List<ShowSeat> showSeatList) {
        this.id = id;
        this.user = user;
        this.showSeatList = showSeatList;
        this.amount = calculateAmount();
        this.status = BookingStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ShowSeat> getShowSeatList() {
        return showSeatList;
    }

    public void setShowSeatList(List<ShowSeat> showSeatList) {
        this.showSeatList = showSeatList;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public int calculateAmount(){
        int amount = 0;
        for(ShowSeat seat : showSeatList){
            amount += seat.getPrice();
        }
        return amount;
    }
}
