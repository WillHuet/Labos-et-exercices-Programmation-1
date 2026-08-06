package strategies;

import api.Direction;
import api.ElevatorDecision;
import api.IBuilding;
import api.IElevator;

final class StrategySupport {
    private StrategySupport() {
    }

    static boolean shouldOpenHere(IBuilding building, IElevator elevator) {
        int floor = elevator.getCurrentFloor();
        return !elevator.hasOpenedDoorsAtCurrentFloor()
                && (elevator.getDestinationFloors().contains(floor)
                        || building.getWaitingPassengersGoingUp(floor) > 0
                        || building.getWaitingPassengersGoingDown(floor) > 0);
    }

    static ElevatorDecision moveToward(int currentFloor, int targetFloor) {
        if (targetFloor > currentFloor) {
            return ElevatorDecision.MOVE_UP;
        }
        if (targetFloor < currentFloor) {
            return ElevatorDecision.MOVE_DOWN;
        }
        return ElevatorDecision.OPEN_DOORS;
    }

    static boolean hasDemandAbove(IBuilding building, IElevator elevator) {
        int floor = elevator.getCurrentFloor();
        for (int destination : elevator.getDestinationFloors()) {
            if (destination > floor) {
                return true;
            }
        }
        for (int candidate = floor + 1; candidate <= building.getNumberOfFloors(); candidate++) {
            if (hasWaitingAt(building, candidate)) {
                return true;
            }
        }
        return false;
    }

    static boolean hasDemandBelow(IBuilding building, IElevator elevator) {
        int floor = elevator.getCurrentFloor();
        for (int destination : elevator.getDestinationFloors()) {
            if (destination < floor) {
                return true;
            }
        }
        for (int candidate = floor - 1; candidate >= 1; candidate--) {
            if (hasWaitingAt(building, candidate)) {
                return true;
            }
        }
        return false;
    }

    static boolean hasWaitingAt(IBuilding building, int floor) {
        return building.getWaitingPassengersGoingUp(floor) > 0 || building.getWaitingPassengersGoingDown(floor) > 0;
    }

    static int nearestWaitingFloor(IBuilding building, int currentFloor) {
        int bestFloor = -1;
        int bestDistance = Integer.MAX_VALUE;
        long bestTime = Long.MAX_VALUE;
        for (int floor = 1; floor <= building.getNumberOfFloors(); floor++) {
            long oldest = building.getOldestWaitingRequestTime(floor);
            if (oldest == Long.MAX_VALUE) {
                continue;
            }
            int distance = Math.abs(currentFloor - floor);
            if (distance < bestDistance || distance == bestDistance && oldest < bestTime) {
                bestDistance = distance;
                bestTime = oldest;
                bestFloor = floor;
            }
        }
        return bestFloor;
    }

    static int oldestWaitingFloor(IBuilding building) {
        int bestFloor = -1;
        long bestTime = Long.MAX_VALUE;
        for (int floor = 1; floor <= building.getNumberOfFloors(); floor++) {
            long oldest = building.getOldestWaitingRequestTime(floor);
            if (oldest < bestTime) {
                bestTime = oldest;
                bestFloor = floor;
            }
        }
        return bestFloor;
    }

    static int closestDestination(IElevator elevator) {
        int bestFloor = -1;
        int bestDistance = Integer.MAX_VALUE;
        for (int destination : elevator.getDestinationFloors()) {
            int distance = Math.abs(elevator.getCurrentFloor() - destination);
            if (distance < bestDistance) {
                bestDistance = distance;
                bestFloor = destination;
            }
        }
        return bestFloor;
    }

    static Direction opposite(Direction direction) {
        return direction == Direction.UP ? Direction.DOWN : Direction.UP;
    }
}
