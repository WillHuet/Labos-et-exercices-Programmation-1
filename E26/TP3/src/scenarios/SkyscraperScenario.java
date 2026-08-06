package scenarios;

import api.IScenario;

public class SkyscraperScenario implements IScenario {
    @Override
    public String getName() {
        return "Skycraper";
    }

    @Override
    public int getFloorCount() {
        return 40;
    }

    @Override
    public int getElevatorCount() {
        return 12;
    }

    @Override
    public int getEmployeeCount() {
        return 3000;
    }

    @Override
    public int getElevatorCapacity() {
        return 12;
    }

    @Override
    public int getElevatorWeightCapacity() {
        return 1200;
    }

    @Override
    public int getFloorTravelTimeInSeconds() {
        return 3;
    }

    @Override
    public long getDurationInSeconds() {
        return 86400;
    }
}
