package api;

/**
 * Describes one simulated building and workday: how it's laid out, how many
 * elevators serve it and their physical limits, and how long the simulation
 * should run for.
 */
public interface IScenario
{
    /** Display name used when printing this run's statistics. */
    String getName();

    /** Total number of floors; floor 1 is the ground floor / lobby. */
    int getFloorCount();

    /** Number of elevators serving the building. */
    int getElevatorCount();

    /** Total number of passengers simulated over the day. */
    int getEmployeeCount();

    /** Maximum number of passengers a single elevator can carry at once. */
    int getElevatorCapacity();

    /**
     * Maximum combined weight (in kg) a single elevator can carry at once.
     * Enforced alongside {@link #getElevatorCapacity()} — whichever limit is
     * reached first stops further boarding.
     */
    int getElevatorWeightCapacity();

    /** Time (in seconds) it takes an elevator to travel between two adjacent floors. */
    int getFloorTravelTimeInSeconds();

    /** Total simulated duration, in seconds since midnight. */
    long getDurationInSeconds();
}
