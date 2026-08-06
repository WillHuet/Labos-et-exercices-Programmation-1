package elevator;

import java.util.concurrent.atomic.AtomicInteger;

public class Passenger {
    private static final AtomicInteger NEXT_ID = new AtomicInteger();

    private final int id;
    private final int weightInKg;
    private final int workFloor;
    private final long arrivalTime;
    private final long lunchTime;
    private final long lunchDuration;
    private final long departureTime;

    public Passenger(int weightInKg, int workFloor, long arrivalTime, long lunchTime, long lunchDuration,
            long departureTime) {
        this.id = NEXT_ID.incrementAndGet();
        this.weightInKg = weightInKg;
        this.workFloor = workFloor;
        this.arrivalTime = arrivalTime;
        this.lunchTime = lunchTime;
        this.lunchDuration = lunchDuration;
        this.departureTime = departureTime;
    }

    public int getId() {
        return id;
    }

    public int getWeightInKg() {
        return weightInKg;
    }

    public int getWorkFloor() {
        return workFloor;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public long getLunchTime() {
        return lunchTime;
    }

    public long getLunchDuration() {
        return lunchDuration;
    }

    public long getLunchReturnTime() {
        return lunchTime + lunchDuration;
    }

    public long getDepartureTime() {
        return departureTime;
    }
}
