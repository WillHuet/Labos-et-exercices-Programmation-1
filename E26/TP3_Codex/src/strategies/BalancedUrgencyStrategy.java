package strategies;

import api.Direction;
import api.ElevatorContext;
import api.ElevatorDecision;
import api.IBuilding;
import api.IElevator;
import api.IElevatorStrategy;

public class BalancedUrgencyStrategy implements IElevatorStrategy {
    private static final int DISTANCE_PENALTY_SECONDS = 20;

    @Override
    public String getName() {
        return "BalancedUrgencyStrategy";
    }

    @Override
    public ElevatorDecision chooseNextAction(ElevatorContext elevatorContext) {
        IBuilding building = elevatorContext.getBuilding();
        IElevator elevator = elevatorContext.getElevator();

        if (StrategySupport.shouldOpenHere(building, elevator)) {
            return ElevatorDecision.OPEN_DOORS;
        }

        if (!elevator.getDestinationFloors().isEmpty()) {
            int closestDestination = StrategySupport.closestDestination(elevator);
            return StrategySupport.moveToward(elevator.getCurrentFloor(), closestDestination);
        }

        int targetFloor = bestAvailableFloorForElevator(building, elevator, elevatorContext.getCurrentTime());
        if (targetFloor == -1) {
            return ElevatorDecision.STAY_IDLE;
        }
        return StrategySupport.moveToward(elevator.getCurrentFloor(), targetFloor);
    }

    private int bestAvailableFloorForElevator(IBuilding building, IElevator elevator, long currentTime) {
        int bestFloor = -1;
        long bestScore = Long.MIN_VALUE;
        for (int floor = 1; floor <= building.getNumberOfFloors(); floor++) {
            long oldest = building.getOldestWaitingRequestTime(floor);
            if (oldest == Long.MAX_VALUE || !isClosestIdleElevator(building, elevator, floor)) {
                continue;
            }
            long waitTime = currentTime - oldest;
            long score = waitTime - (long) Math.abs(elevator.getCurrentFloor() - floor) * DISTANCE_PENALTY_SECONDS;
            if (score > bestScore) {
                bestScore = score;
                bestFloor = floor;
            }
        }

        if (bestFloor == -1) {
            return StrategySupport.nearestWaitingFloor(building, elevator.getCurrentFloor());
        }
        return bestFloor;
    }

    private boolean isClosestIdleElevator(IBuilding building, IElevator elevator, int floor) {
        int myDistance = Math.abs(elevator.getCurrentFloor() - floor);
        for (IElevator other : building.getElevators()) {
            if (other.getId() == elevator.getId() || other.getDirection() != Direction.IDLE
                    || !other.getDestinationFloors().isEmpty()) {
                continue;
            }
            int otherDistance = Math.abs(other.getCurrentFloor() - floor);
            if (otherDistance < myDistance || otherDistance == myDistance && other.getId() < elevator.getId()) {
                return false;
            }
        }
        return true;
    }
}
