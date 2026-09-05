package elevator.service;

import elevator.domain.DestinationRequest;
import elevator.domain.Elevator;
import elevator.domain.OutsideRequest;
import elevator.interfaces.ElevatorStrategy;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ElevatorService {

    private ElevatorStrategy strategy;
    ExecutorService service ;

    public ElevatorService(ElevatorStrategy strategy, int numThreads) {
        this.strategy = strategy;
        this.service = Executors.newFixedThreadPool(numThreads);
    }

    public void findNearestElevator(List<Elevator> elevatorList, OutsideRequest request){
        Elevator elevator = strategy.findElevator(elevatorList, request);
        DestinationRequest destinationRequest = new DestinationRequest(0, request.getFloorNumber(), elevator);
        elevator.addDestinationRequest(destinationRequest);
        if(elevator.tryAndStartProcessing()){
            service.submit(elevator::process);
        }
    }

    private void processInsideRequest(DestinationRequest destinationRequest) {
        Elevator elevator = destinationRequest.getElevator();
        elevator.addDestinationRequest(destinationRequest);
        if(elevator.tryAndStartProcessing()){
            service.submit(elevator::process);
        }
    }

    public ElevatorStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ElevatorStrategy strategy) {
        this.strategy = strategy;
    }
}
