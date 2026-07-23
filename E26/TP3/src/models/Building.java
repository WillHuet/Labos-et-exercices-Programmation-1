package models;

import api.IBuilding;
import api.IElevator;

import java.util.List;

public class Building implements IBuilding {
    private List<Floor> floors;

    private List<Elevator> elevators;

    public Building(List<Floor> floors, List<Elevator> elevators) {
        this.floors = floors;
        this.elevators = elevators;
    }

    public Floor getFloor(int floorNumber) {
        return floors.get(floorNumber -1);
    }

    @Override
    public int getNumberOfFloors() {
        return floors.size();
    }
    // *****
    @Override
    public int getWaitingPassengersGoingUp(int floor) {
        return floors.get(floor-1)
                .getWaitingUp()
                .size();
    }

    // ****
    @Override
    public int getWaitingPassengersGoingDown(int floor) {
        return floors.get(floor-1)
                .getWaitingDown()
                .size();
    }

    //****
    @Override
    public long getOldestWaitingRequestTime(int floor) {
        return Long.MAX_VALUE;
    }

    @Override
    public List<IElevator> getElevators() {
        return List.copyOf(elevators);
    }
}
