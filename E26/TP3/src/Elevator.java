import api.Direction;
import api.ElevatorDecision;
import api.IElevator;

import java.util.List;

public class Elevator implements IElevator {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getCurrentFloor() {
        return 0;
    }

    @Override
    public Direction getDirection() {
        return null;
    }

    @Override
    public List<Integer> getDestinationFloors() {
        return List.of();
    }

    @Override
    public boolean hasOpenedDoorsAtCurrentFloor() {
        return false;
    }

    @Override
    public void executeDecision(ElevatorDecision decision) {

    }
}
