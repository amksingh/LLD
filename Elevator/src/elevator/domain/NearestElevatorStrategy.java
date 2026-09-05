package elevator.domain;

import elevator.interfaces.ElevatorStrategy;

import java.util.Iterator;
import java.util.List;

public class NearestElevatorStrategy implements ElevatorStrategy {


    @Override
    public Elevator findElevator(List<Elevator> elevators, OutsideRequest request) {
        int minCost = Integer.MAX_VALUE;
        Elevator elevator = null;
        Iterator<Elevator> iterator = elevators.iterator();
        while(iterator.hasNext()){
            Elevator curElevator = iterator.next();
            int cost = calculateCost(curElevator, request);
            if(cost < minCost){
                elevator = curElevator;
                minCost = cost;
            }
        }
        return elevator;
    }

    private int calculateCost(Elevator elevator, OutsideRequest request) {
        Direction eleDirection = elevator.getDirection();
        int eleFloor = elevator.getCurrentFloor();

        Direction direction = request.getDirection();
        int floor = request.getFloorNumber();

        int cost = Integer.MAX_VALUE;
        int penality = 100;

        //case 1 when elevator is idel
        if(eleDirection.equals(Direction.IDEL)){
            cost = Math.abs(floor - eleFloor);
        }else if(direction.equals(Direction.UP) && eleDirection.equals(Direction.UP)){
            //case 2 when elevator is down but coming up
            if(eleFloor < floor){
                cost = floor - eleFloor;
            }else{
                cost = Math.abs(floor - eleFloor) + penality;
            }
        }else if(direction.equals(Direction.DOWN) && eleDirection.equals(Direction.DOWN)){
            //case 2 when elevator is down but coming up
            if(eleFloor < floor){
                cost = floor - eleFloor;
            }else{
                cost = Math.abs(floor - eleFloor) + penality;
            }
        }
        else{
            if(eleFloor > floor){
                cost = eleFloor - floor;
            }else{
                cost = Math.abs(eleFloor - floor) + penality;
            }
        }
        return  cost;

    }
}
