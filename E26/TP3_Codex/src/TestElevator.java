
import java.util.Collections;
import java.util.List;

import api.Direction;
import api.ElevatorDecision;
import api.IElevator;

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
