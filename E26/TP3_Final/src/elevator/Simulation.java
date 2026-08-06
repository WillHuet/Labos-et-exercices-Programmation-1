package elevator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import elevator.api.Direction;
import elevator.api.ElevatorContext;
import elevator.api.ElevatorDecision;
import elevator.api.IElevatorStrategy;
import elevator.api.IScenario;

public class Simulation {
    private static final int LOBBY_FLOOR = 1;
    private static final int MIN_WEIGHT = 50;
    private static final int MAX_EXTRA_WEIGHT = 51;
    private static final long MORNING_START = 7 * 3600 + 30 * 60;
    private static final long MORNING_END = 9 * 3600;
    private static final long LUNCH_START = 11 * 3600 + 30 * 60;
    private static final long LUNCH_END = 13 * 3600;
    private static final long MIN_LUNCH_DURATION = 30 * 60;
    private static final long MAX_EXTRA_LUNCH_DURATION = 60 * 60 + 1;
    private static final long DEPARTURE_START = 16 * 3600;
    private static final long DEPARTURE_END = 18 * 3600;

    private final IScenario scenario;
    private final IElevatorStrategy strategy;
    private final SimulationStats stats;
    private final Building building;
    private final List<TravelRequest> schedule;
    private int nextScheduledRequest;
    private long currentTime;

    public Simulation(IScenario scenario, IElevatorStrategy strategy) {
        this.scenario = scenario;
        this.strategy = strategy;
        this.stats = new SimulationStats();
        this.building = new Building(scenario, stats);
        this.schedule = createSchedule(scenario);
        this.nextScheduledRequest = 0;
        this.currentTime = 0;
    }

    public void tick() {
        addNewRequests();
        for (Elevator elevator : building.getMutableElevators()) {
            elevator.tickMovement();
        }
        for (Elevator elevator : building.getMutableElevators()) {
            if (elevator.getDirection() == Direction.IDLE) {
                ElevatorContext context = new ElevatorContext(building, elevator, currentTime);
                ElevatorDecision decision = strategy.chooseNextAction(context);
                elevator.executeDecision(decision, currentTime);
            }
        }
        recordOccupancy();
        currentTime++;
    }

    public SimulationStats run() {
        while (currentTime <= scenario.getDurationInSeconds() || hasUnfinishedWork()) {
            tick();
        }
        return stats;
    }

    private boolean hasUnfinishedWork() {
        if (nextScheduledRequest < schedule.size() || building.hasWaitingPassengers()) {
            return true;
        }
        for (Elevator elevator : building.getMutableElevators()) {
            if (elevator.hasPassengers() || elevator.getDirection() != Direction.IDLE) {
                return true;
            }
        }
        return false;
    }

    private void addNewRequests() {
        while (nextScheduledRequest < schedule.size()
                && schedule.get(nextScheduledRequest).getRequestTime() <= currentTime) {
            building.addRequest(schedule.get(nextScheduledRequest));
            nextScheduledRequest++;
        }
    }

    private void recordOccupancy() {
        for (Elevator elevator : building.getMutableElevators()) {
            if (elevator.getDirection() != Direction.IDLE) {
                stats.recordOccupancy(elevator.getPassengerCount(), elevator.getPassengerCapacity());
            }
        }
    }

    private List<TravelRequest> createSchedule(IScenario scenario) {
        Random random = new Random(scenario.getName().hashCode());
        List<TravelRequest> requests = new ArrayList<TravelRequest>();
        for (int i = 0; i < scenario.getEmployeeCount(); i++) {
            int workFloor = randomInt(random, 2, scenario.getFloorCount());
            int weight = MIN_WEIGHT + random.nextInt(MAX_EXTRA_WEIGHT);
            long arrival = randomLong(random, MORNING_START, MORNING_END);
            long lunch = randomLong(random, LUNCH_START, LUNCH_END);
            long lunchDuration = MIN_LUNCH_DURATION + random.nextInt((int) MAX_EXTRA_LUNCH_DURATION);
            long departure = randomLong(random, DEPARTURE_START, DEPARTURE_END);
            Passenger passenger = new Passenger(weight, workFloor, arrival, lunch, lunchDuration, departure);

            requests.add(new TravelRequest(passenger, LOBBY_FLOOR, workFloor, passenger.getArrivalTime()));
            requests.add(new TravelRequest(passenger, workFloor, LOBBY_FLOOR, passenger.getLunchTime()));
            requests.add(new TravelRequest(passenger, LOBBY_FLOOR, workFloor, passenger.getLunchReturnTime()));
            requests.add(new TravelRequest(passenger, workFloor, LOBBY_FLOOR, passenger.getDepartureTime()));
        }
        requests.sort(Comparator.comparingLong(TravelRequest::getRequestTime));
        return requests;
    }

    private int randomInt(Random random, int minimum, int maximum) {
        if (maximum <= minimum) {
            return minimum;
        }
        return minimum + random.nextInt(maximum - minimum + 1);
    }

    private long randomLong(Random random, long minimum, long maximum) {
        if (maximum <= minimum) {
            return minimum;
        }
        return minimum + Math.floorMod(random.nextLong(), maximum - minimum + 1);
    }
}
