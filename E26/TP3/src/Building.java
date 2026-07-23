import api.IBuilding;
import api.IElevator;

import java.util.List;

public class Building implements IBuilding {
    private int numberOfFloors;
    private int currentFloor;
    private List<Elevator> elevators;

    public Building(int numberOfFloors, int numberOfElevators, int currentFloor) {}

    @Override
    public int getNumberOfFloors() {
        return 0;
    }

    @Override
    public int getWaitingPassengersGoingUp(int floor) {
        return 0;
    }

    @Override
    public int getWaitingPassengersGoingDown(int floor) {
        return 0;
    }

    @Override
    public long getOldestWaitingRequestTime(int floor) {
        return 0;
    }

    @Override
    public List<IElevator> getElevators() {
        return List.of();
    }
}
