import api.IScenario;

public class Scenario implements IScenario {
    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getFloorCount() {
        return 0;
    }

    @Override
    public int getElevatorCount() {
        return 0;
    }

    @Override
    public int getEmployeeCount() {
        return 0;
    }

    @Override
    public int getElevatorCapacity() {
        return 0;
    }

    @Override
    public int getElevatorWeightCapacity() {
        return 0;
    }

    @Override
    public int getFloorTravelTimeInSeconds() {
        return 0;
    }

    @Override
    public long getDurationInSeconds() {
        return 0;
    }
}
