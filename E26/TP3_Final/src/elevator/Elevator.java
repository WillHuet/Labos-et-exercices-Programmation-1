package elevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import elevator.api.Direction;
import elevator.api.ElevatorDecision;
import elevator.api.IElevator;

public class Elevator implements IElevator {
    private final int id;
    private final int passengerCapacity;
    private final int weightCapacity;
    private final int floorTravelTimeInSeconds;
    private final Building building;
    private final SimulationStats stats;
    private final List<TravelRequest> passengers;
    private final List<Integer> destinationFloors;

    private int currentFloor;
    private Direction direction;
    private int remainingTravelSeconds;
    private boolean openedDoorsAtCurrentFloor;
    private int currentWeight;

    public Elevator(int id, int passengerCapacity, int weightCapacity, int floorTravelTimeInSeconds, Building building,
            SimulationStats stats) {
        this.id = id;
        this.passengerCapacity = passengerCapacity;
        this.weightCapacity = weightCapacity;
        this.floorTravelTimeInSeconds = floorTravelTimeInSeconds;
        this.building = building;
        this.stats = stats;
        this.passengers = new ArrayList<TravelRequest>();
        this.destinationFloors = new ArrayList<Integer>();
        this.currentFloor = 1;
        this.direction = Direction.IDLE;
        this.remainingTravelSeconds = 0;
        this.openedDoorsAtCurrentFloor = false;
        this.currentWeight = 0;
    }

    public void tickMovement() {
        if (direction == Direction.IDLE) {
            return;
        }

        remainingTravelSeconds--;
        if (remainingTravelSeconds <= 0) {
            currentFloor += direction == Direction.UP ? 1 : -1;
            direction = Direction.IDLE;
            openedDoorsAtCurrentFloor = false;
            stats.recordFloorTravelled();
        }
    }

    public boolean canAccept(TravelRequest request) {
        return passengers.size() < passengerCapacity && currentWeight + request.getPassenger().getWeightInKg() <= weightCapacity;
    }

    public void addPassenger(TravelRequest request, long currentTime) {
        passengers.add(request);
        destinationFloors.add(request.getDestinationFloor());
        currentWeight += request.getPassenger().getWeightInKg();
        stats.recordPickup(currentTime - request.getRequestTime());
    }

    public boolean hasPassengers() {
        return !passengers.isEmpty();
    }

    public int getPassengerCount() {
        return passengers.size();
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    private void openDoors(long currentTime) {
        openedDoorsAtCurrentFloor = true;
        stats.recordStop();
        unloadPassengers();
        building.boardPassengers(this, currentTime);
    }

    private void unloadPassengers() {
        Iterator<TravelRequest> iterator = passengers.iterator();
        while (iterator.hasNext()) {
            TravelRequest request = iterator.next();
            if (request.getDestinationFloor() == currentFloor) {
                iterator.remove();
                destinationFloors.remove(Integer.valueOf(currentFloor));
                currentWeight -= request.getPassenger().getWeightInKg();
                stats.recordDelivery();
            }
        }
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
        return Collections.unmodifiableList(destinationFloors);
    }

    @Override
    public boolean hasOpenedDoorsAtCurrentFloor() {
        return openedDoorsAtCurrentFloor;
    }

    @Override
    public void executeDecision(ElevatorDecision decision) {
        executeDecision(decision, 0);
    }

    public void executeDecision(ElevatorDecision decision, long currentTime) {
        if (direction != Direction.IDLE) {
            return;
        }

        if (decision == ElevatorDecision.MOVE_UP && currentFloor < building.getNumberOfFloors()) {
            direction = Direction.UP;
            remainingTravelSeconds = floorTravelTimeInSeconds;
        } else if (decision == ElevatorDecision.MOVE_DOWN && currentFloor > 1) {
            direction = Direction.DOWN;
            remainingTravelSeconds = floorTravelTimeInSeconds;
        } else if (decision == ElevatorDecision.OPEN_DOORS) {
            openDoors(currentTime);
        }
    }
}
