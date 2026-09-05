package elevator.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Elevator {

    private int id;
    private int currentFloor;
    private Direction direction;
    PriorityQueue<DestinationRequest> upQueue;
    PriorityQueue<DestinationRequest> downQueue;
    private AtomicBoolean processing;

    public Elevator(int id, int currentFloor) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.direction = Direction.IDEL;
        this.upQueue = new PriorityQueue<>(Comparator.comparing(DestinationRequest::getFloorNumber));
        this.downQueue = new PriorityQueue<>(Comparator.comparing(DestinationRequest::getFloorNumber).reversed());
        this.processing = new AtomicBoolean();
    }

    public boolean getProcessing() {
        return processing.get();
    }

    public void move(int floorNumber){
        openDoor();
        setCurrentFloor(floorNumber);
        closeDoor();
    }

    public void process(){
        if(getDirection().equals(Direction.UP) || getDirection().equals(Direction.IDEL)){
            processUpRequest();
            processDownRequest();
        }else{
            processDownRequest();
            processUpRequest();
        }
        synchronized (this) {
            if (downQueue.isEmpty() && upQueue.isEmpty()) {
                processing.set(false);
            }else{
                process();
            }
        }

    }

    public void processUpRequest(){
        setDirection(Direction.UP);
        while(true){
            DestinationRequest request = null;
            synchronized (this) {
                request = upQueue.poll();
            }
            if(request == null){
                break;
            }
            move(request.getFloorNumber());
        }
    }

    public void processDownRequest(){
        setDirection(Direction.DOWN);
        while(true){
            DestinationRequest request = null;
            synchronized (this) {
                request = downQueue.poll();
            }
            if(request == null){
                break;
            }
            move(request.getFloorNumber());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public synchronized void addDestinationRequest(DestinationRequest destinationRequest) {
       int floor = destinationRequest.getFloorNumber();
       Direction dir = null;
       if(currentFloor < floor){
           dir = Direction.UP;
       }else{
           dir = Direction.DOWN;
       }
       if(dir == Direction.UP){
           upQueue.offer(destinationRequest);
       }else{
           downQueue.offer(destinationRequest);
       }
    }

    public void openDoor(){
        System.out.println("Reached the floor opening door");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeDoor(){
        System.out.println("closing the door");
    }

    public boolean tryAndStartProcessing(){
        return processing.compareAndSet(false, true);
    }
}
