package api;

import java.util.List;

/**
 * Read-only view of the building that a strategy can query to decide what an
 * elevator should do next. Floors are numbered from 1 (the ground floor / lobby)
 * to {@link #getNumberOfFloors()}.
 */
public interface IBuilding
{
    /** Total number of floors in the building. */
    int getNumberOfFloors();

    /** Number of passengers currently waiting at {@code floor} whose destination is above it. */
    int getWaitingPassengersGoingUp(int floor);

    /** Number of passengers currently waiting at {@code floor} whose destination is below it. */
    int getWaitingPassengersGoingDown(int floor);

    /**
     * The timestamp (seconds since the start of the simulated day) at which the
     * oldest passenger still waiting at {@code floor} made their request, or
     * {@code Long.MAX_VALUE} if nobody is currently waiting there.
     */
    long getOldestWaitingRequestTime(int floor);

    /** All elevators in the building, in a fixed order (see {@link IElevator#getId()}). */
    List<IElevator> getElevators();
}
