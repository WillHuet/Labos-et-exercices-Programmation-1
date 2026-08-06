package elevator;

import elevator.api.Direction;

public class TravelRequest {
    private final Passenger passenger;
    private final int originFloor;
    private final int destinationFloor;
    private final long requestTime;

    public TravelRequest(Passenger passenger, int originFloor, int destinationFloor, long requestTime) {
        this.passenger = passenger;
        this.originFloor = originFloor;
        this.destinationFloor = destinationFloor;
        this.requestTime = requestTime;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getOriginFloor() {
        return originFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public Direction getDirection() {
        return destinationFloor > originFloor ? Direction.UP : Direction.DOWN;
    }
}
