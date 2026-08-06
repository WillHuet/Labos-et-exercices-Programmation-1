package models;

public class Passenger {
    private final int id;
    private final double weight;
    private final int workFloor;

    private final long arrivalTime;
    private final long lunchTime;
    private final long lunchDuration;
    private final long departureTime;

    private int currentFloor;
    private int destinationFloor;

    private long requestTime;
    private long boardingTime;

    public Passenger(int id, double weight, int workFloor, long arrivalTime, long lunchTime, long lunchDuration, long departureTime) {
        this.id = id;
        this.weight = weight;
        this.workFloor = workFloor;
        this.arrivalTime = arrivalTime;
        this.lunchTime = lunchTime;
        this.lunchDuration = lunchDuration;
        this.departureTime = departureTime;

        this.currentFloor = 1;
    }

    public int getId() {
        return id;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(long requestTime) {
        this.requestTime = requestTime;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
