package elevator.domain;

public class DestinationRequest {
    private int id;
    private int floorNumber;
    private Elevator elevator;

    public DestinationRequest(int id, int floorNumber, Elevator elevator) {
        this.id = id;
        this.floorNumber = floorNumber;
        this.elevator = elevator;
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

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }
}
