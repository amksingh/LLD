package domain;

import javax.swing.text.DefaultEditorKit;

public class Payment {

    private int id;
    private int bookingId;
    private PaymentStatus status;
    private int amount;

    public Payment(int id, int bookingId, int amount) {
        this.id = id;
        this.bookingId = bookingId;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public int getBookingId() {
        return bookingId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public int getAmount() {
        return amount;
    }

    public  void complete(){
        if(this.status == PaymentStatus.PENDING)
            this.status = PaymentStatus.COMPLETED;
    }

    public void failed(){
        if(this.status == PaymentStatus.PENDING)
            this.status = PaymentStatus.FAILED;
    }
}
