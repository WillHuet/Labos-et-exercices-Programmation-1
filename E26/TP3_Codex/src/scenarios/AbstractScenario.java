package scenarios;

import api.IScenario;

public abstract class AbstractScenario implements IScenario {
    private static final int DEFAULT_ELEVATOR_CAPACITY = 8;
    private static final int DEFAULT_ELEVATOR_WEIGHT_CAPACITY = 700;
    private static final int DEFAULT_FLOOR_TRAVEL_TIME = 5;
    private static final long DEFAULT_DURATION = 18 * 3600;

    private final String name;
    private final int floorCount;
    private final int elevatorCount;
    private final int employeeCount;

    protected AbstractScenario(String name, int floorCount, int elevatorCount, int employeeCount) {
        this.name = name;
        this.floorCount = floorCount;
        this.elevatorCount = elevatorCount;
        this.employeeCount = employeeCount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getFloorCount() {
        return floorCount;
    }

    @Override
    public int getElevatorCount() {
        return elevatorCount;
    }

    @Override
    public int getEmployeeCount() {
        return employeeCount;
    }

    @Override
    public int getElevatorCapacity() {
        return DEFAULT_ELEVATOR_CAPACITY;
    }

    @Override
    public int getElevatorWeightCapacity() {
        return DEFAULT_ELEVATOR_WEIGHT_CAPACITY;
    }

    @Override
    public int getFloorTravelTimeInSeconds() {
        return DEFAULT_FLOOR_TRAVEL_TIME;
    }

    @Override
    public long getDurationInSeconds() {
        return DEFAULT_DURATION;
    }
}
