package elevator.strategies;

import elevator.api.ElevatorContext;
import elevator.api.ElevatorDecision;
import elevator.api.IBuilding;
import elevator.api.IElevator;
import elevator.api.IElevatorStrategy;

public class FIFOStrategy implements IElevatorStrategy {
    @Override
    public String getName() {
        return "FIFOStrategy";
    }

    @Override
    public ElevatorDecision chooseNextAction(ElevatorContext elevatorContext) {
        IBuilding building = elevatorContext.getBuilding();
        IElevator elevator = elevatorContext.getElevator();

        if (StrategySupport.shouldOpenHere(building, elevator)) {
            return ElevatorDecision.OPEN_DOORS;
        }

        if (!elevator.getDestinationFloors().isEmpty()) {
            return StrategySupport.moveToward(elevator.getCurrentFloor(), elevator.getDestinationFloors().get(0));
        }

        int oldestFloor = StrategySupport.oldestWaitingFloor(building);
        if (oldestFloor == -1) {
            return ElevatorDecision.STAY_IDLE;
        }
        return StrategySupport.moveToward(elevator.getCurrentFloor(), oldestFloor);
    }
}
