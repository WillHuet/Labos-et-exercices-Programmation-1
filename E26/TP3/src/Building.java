import api.IBuilding;
import api.IElevator;

import java.util.List;

public class Building implements IBuilding {
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
