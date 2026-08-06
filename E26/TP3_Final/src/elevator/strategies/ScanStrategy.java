package elevator.strategies;

import java.util.HashMap;
import java.util.Map;

import elevator.api.Direction;
import elevator.api.ElevatorContext;
import elevator.api.ElevatorDecision;
import elevator.api.IBuilding;
import elevator.api.IElevator;
import elevator.api.IElevatorStrategy;

public class ScanStrategy implements IElevatorStrategy {
    private final Map<Integer, Direction> directionsByElevatorId = new HashMap<Integer, Direction>();

    @Override
    public String getName() {
        return "ScanStrategy";
    }

    @Override
    public ElevatorDecision chooseNextAction(ElevatorContext elevatorContext) {
        IBuilding building = elevatorContext.getBuilding();
        IElevator elevator = elevatorContext.getElevator();
        Direction direction = directionsByElevatorId.getOrDefault(elevator.getId(), Direction.UP);

        if (StrategySupport.shouldOpenHere(building, elevator)) {
            return ElevatorDecision.OPEN_DOORS;
        }

        if (direction == Direction.UP) {
            if (StrategySupport.hasDemandAbove(building, elevator)) {
                return ElevatorDecision.MOVE_UP;
            }
            directionsByElevatorId.put(elevator.getId(), Direction.DOWN);
            if (StrategySupport.hasDemandBelow(building, elevator)) {
                return ElevatorDecision.MOVE_DOWN;
            }
        } else {
            if (StrategySupport.hasDemandBelow(building, elevator)) {
                return ElevatorDecision.MOVE_DOWN;
            }
            directionsByElevatorId.put(elevator.getId(), Direction.UP);
            if (StrategySupport.hasDemandAbove(building, elevator)) {
                return ElevatorDecision.MOVE_UP;
            }
        }

        return ElevatorDecision.STAY_IDLE;
    }
}
