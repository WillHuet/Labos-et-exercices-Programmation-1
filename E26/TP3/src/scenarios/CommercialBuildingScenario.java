package scenarios;

import api.IScenario;

public class CommercialBuildingScenario implements IScenario {
    @Override
    public String getName() {
        return "Commercial Building";
    }

    @Override
    public int getFloorCount() {
        return 12;
    }

    @Override
    public int getElevatorCount() {
        return 3;
    }

    @Override
    public int getEmployeeCount() {
        return 350;
    }

    @Override
    public int getElevatorCapacity() {
        return 10;
    }

    @Override
    public int getElevatorWeightCapacity() {
        return 1000;
    }

    @Override
    public int getFloorTravelTimeInSeconds() {
        return 3;
    }

    @Override
    public long getDurationInSeconds() {
        return 36400;
    }
}
