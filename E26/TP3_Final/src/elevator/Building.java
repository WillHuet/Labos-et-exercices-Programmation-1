package elevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import elevator.api.Direction;
import elevator.api.IBuilding;
import elevator.api.IElevator;
import elevator.api.IScenario;

public class Building implements IBuilding {
    private final int numberOfFloors;
    private final List<Elevator> elevators;
    private final List<Queue<TravelRequest>> waitingUp;
    private final List<Queue<TravelRequest>> waitingDown;

    public Building(IScenario scenario, SimulationStats stats) {
        this.numberOfFloors = scenario.getFloorCount();
        this.elevators = new ArrayList<Elevator>();
        this.waitingUp = createFloorQueues(numberOfFloors);
        this.waitingDown = createFloorQueues(numberOfFloors);

        for (int i = 0; i < scenario.getElevatorCount(); i++) {
            elevators.add(new Elevator(i, scenario.getElevatorCapacity(), scenario.getElevatorWeightCapacity(),
                    scenario.getFloorTravelTimeInSeconds(), this, stats));
        }
    }

    private static List<Queue<TravelRequest>> createFloorQueues(int floorCount) {
        List<Queue<TravelRequest>> queues = new ArrayList<Queue<TravelRequest>>();
        for (int i = 0; i <= floorCount; i++) {
            queues.add(new LinkedList<TravelRequest>());
        }
        return queues;
    }

    public void addRequest(TravelRequest request) {
        queueFor(request.getOriginFloor(), request.getDirection()).add(request);
    }

    public boolean hasWaitingPassengers() {
        for (int floor = 1; floor <= numberOfFloors; floor++) {
            if (!waitingUp.get(floor).isEmpty() || !waitingDown.get(floor).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public int boardPassengers(Elevator elevator, long currentTime) {
        Direction preferredDirection = chooseBoardingDirection(elevator);
        int boarded = boardFromQueue(elevator, queueFor(elevator.getCurrentFloor(), preferredDirection), currentTime);

        if (boarded == 0 && !elevator.hasPassengers()) {
            Direction otherDirection = preferredDirection == Direction.UP ? Direction.DOWN : Direction.UP;
            boarded = boardFromQueue(elevator, queueFor(elevator.getCurrentFloor(), otherDirection), currentTime);
        }

        return boarded;
    }

    private Direction chooseBoardingDirection(Elevator elevator) {
        if (elevator.hasPassengers()) {
            int nextFloor = elevator.getDestinationFloors().get(0);
            return nextFloor > elevator.getCurrentFloor() ? Direction.UP : Direction.DOWN;
        }

        Queue<TravelRequest> up = waitingUp.get(elevator.getCurrentFloor());
        Queue<TravelRequest> down = waitingDown.get(elevator.getCurrentFloor());
        if (down.isEmpty()) {
            return Direction.UP;
        }
        if (up.isEmpty()) {
            return Direction.DOWN;
        }
        return up.peek().getRequestTime() <= down.peek().getRequestTime() ? Direction.UP : Direction.DOWN;
    }

    private int boardFromQueue(Elevator elevator, Queue<TravelRequest> queue, long currentTime) {
        int boarded = 0;
        while (!queue.isEmpty() && elevator.canAccept(queue.peek())) {
            TravelRequest request = queue.remove();
            elevator.addPassenger(request, currentTime);
            boarded++;
        }
        return boarded;
    }

    private Queue<TravelRequest> queueFor(int floor, Direction direction) {
        return direction == Direction.UP ? waitingUp.get(floor) : waitingDown.get(floor);
    }

    public List<Elevator> getMutableElevators() {
        return elevators;
    }

    @Override
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    @Override
    public int getWaitingPassengersGoingUp(int floor) {
        return waitingUp.get(floor).size();
    }

    @Override
    public int getWaitingPassengersGoingDown(int floor) {
        return waitingDown.get(floor).size();
    }

    @Override
    public long getOldestWaitingRequestTime(int floor) {
        List<TravelRequest> candidates = new ArrayList<TravelRequest>();
        candidates.addAll(waitingUp.get(floor));
        candidates.addAll(waitingDown.get(floor));
        if (candidates.isEmpty()) {
            return Long.MAX_VALUE;
        }
        return Collections.min(candidates, Comparator.comparingLong(TravelRequest::getRequestTime)).getRequestTime();
    }

    @Override
    public List<IElevator> getElevators() {
        return Collections.unmodifiableList(new ArrayList<IElevator>(elevators));
    }
}
