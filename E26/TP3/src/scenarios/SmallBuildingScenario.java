package scenarios;

import api.IScenario;

public class SmallBuildingScenario implements IScenario {
    @Override
    public String getName() {
        return "Small Building";
    }

    @Override
    public int getFloorCount() {
        return 3;
    }

    @Override
    public int getElevatorCount() {
        return 1;
    }

    @Override
    public int getEmployeeCount() {
        return 45;
    }

    @Override
    public int getElevatorCapacity() {
        return 8;
    }

    @Override
    public int getElevatorWeightCapacity() {
        return 800;
    }

    @Override
    public int getFloorTravelTimeInSeconds() {
        return 5;
    }

    @Override
    public long getDurationInSeconds() {
        return 86400;
    }
}
