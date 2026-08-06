package elevator.tests;

import java.util.Arrays;
import java.util.List;

import elevator.api.IBuilding;
import elevator.api.IElevator;

class TestBuilding implements IBuilding {
    private final IElevator elevator = new TestElevator();

    @Override
    public int getNumberOfFloors() {
        return 3;
    }

    @Override
    public int getWaitingPassengersGoingUp(int floor) {
        return floor == 1 ? 1 : 0;
    }

    @Override
    public int getWaitingPassengersGoingDown(int floor) {
        return 0;
    }

    @Override
    public long getOldestWaitingRequestTime(int floor) {
        return floor == 1 ? 1 : Long.MAX_VALUE;
    }

    @Override
    public List<IElevator> getElevators() {
        return Arrays.asList(elevator);
    }
}
