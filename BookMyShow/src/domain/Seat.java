package domain;

public class Seat {
    private int id;
    private char row;
    private int col;
    private SeatType type;

    public Seat(int id, char row, int col, SeatType type) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }
}
