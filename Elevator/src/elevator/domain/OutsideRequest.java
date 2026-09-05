package elevator.domain;

public class OutsideRequest {
    private  int id;
    private int floorNumber;
    private Direction direction;

    public OutsideRequest(int id, int floorNumber, Direction direction) {
        this.id = id;
        this.floorNumber = floorNumber;
        this.direction = direction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
