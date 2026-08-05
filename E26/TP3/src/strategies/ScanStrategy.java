package strategies;

import api.Direction;
import api.ElevatorContext;
import api.ElevatorDecision;
import api.IElevatorStrategy;

import java.util.HashMap;
import java.util.Map;

public class ScanStrategy implements IElevatorStrategy {
    private Map<Integer, Direction> lastDirections = new HashMap<>();

    @Override
    public String getName() {
        return "Scan";
    }

    @Override
    public ElevatorDecision chooseNextAction(ElevatorContext elevatorContext) {
        return null;
    }
}
