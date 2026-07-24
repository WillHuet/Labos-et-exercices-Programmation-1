package models;

import api.Direction;
import api.ElevatorDecision;
import api.IElevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator implements IElevator {
    private final int id;
    private final int maxPassengers;
    private final int maxWeight;

    private int currentFloor;
    private Direction direction;
    private boolean openedDoorsAtCurrentFloor;
    private List<Passenger> passengers;
    private int floorTravelTime;

    public Elevator(int id, int maxPassengers, int maxWeight, int floorTravelTime) {
        this.id = id;
        this.maxPassengers = maxPassengers;
        this.maxWeight = maxWeight;
        this.floorTravelTime = floorTravelTime;

        currentFloor = 0;
        direction = Direction.IDLE;

        passengers = new ArrayList<>();
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public int getMaxCapacity() {
        return maxPassengers;
    }

    public int getMaxWieght() {
        return maxWeight;
    }

    public int getFloorTravelTime() {
        return floorTravelTime;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getCurrentFloor() {
        return currentFloor;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public List<Integer> getDestinationFloors() {
        List<Integer> floors = new ArrayList<>();

        for (Passenger p : passengers) {
            floors.add(p.getDestinationFloor());
        }

        return floors;
    }

    @Override
    public boolean hasOpenedDoorsAtCurrentFloor() {
        return openedDoorsAtCurrentFloor;
    }

    @Override
    public void executeDecision(ElevatorDecision decision) {
        switch (decision) {
            case MOVE_UP:
                direction = Direction.UP;
                break;
            case MOVE_DOWN:
                direction = Direction.DOWN;
                break;
            case OPEN_DOORS:
                openedDoorsAtCurrentFloor = true;
                break;
            case STAY_IDLE:
                direction = Direction.IDLE;
                break;
        }
    }

    public void moveOneFloorUp(){
        currentFloor++;
    }

    public void moveOneFloorDown(){
        currentFloor--;
    }

    public void arriveAtFloor(){
        direction = Direction.IDLE;
    }
}
