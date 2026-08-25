package domain;

public enum SeatType {
    SILVER(200),
    GOLD(300),
    PLATINUM(400);

    private final int  price;

    SeatType(int price) {
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }
}
