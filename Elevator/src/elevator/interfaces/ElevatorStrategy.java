package elevator.interfaces;
import elevator.domain.Elevator;
import elevator.domain.OutsideRequest;

import java.util.List;

public interface ElevatorStrategy {

    public Elevator findElevator(List<Elevator> elevators, OutsideRequest request);
}
