package elevator.tests;

import java.util.Collections;
import java.util.List;

import elevator.api.Direction;
import elevator.api.ElevatorDecision;
import elevator.api.IElevator;

class TestElevator implements IElevator {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getCurrentFloor() {
        return 1;
    }

    @Override
    public Direction getDirection() {
        return Direction.IDLE;
    }

    @Override
    public List<Integer> getDestinationFloors() {
        return Collections.emptyList();
    }

    @Override
    public boolean hasOpenedDoorsAtCurrentFloor() {
        return false;
    }

    @Override
    public void executeDecision(ElevatorDecision decision) {
    }
}
