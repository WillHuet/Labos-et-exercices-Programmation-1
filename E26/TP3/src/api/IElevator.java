package api;

import java.util.List;

/**
 * A single elevator car, as seen by a strategy. An elevator only asks its
 * strategy for a decision while {@link #getDirection()} is {@link Direction#IDLE}
 * — that is, right when it arrives at a floor, or when it has nothing to do.
 */
public interface IElevator
{
    /**
     * Stable, 0-based identifier for this elevator, unique within the building.
     * Since a single {@link IElevatorStrategy} instance serves every elevator,
     * this is typically used as a key when a strategy needs to remember
     * something per elevator (e.g. which way it was last heading).
     */
    int getId();

    /** The floor this elevator is currently stopped at. */
    int getCurrentFloor();

    /**
     * The elevator's current motion state. Only {@link Direction#IDLE} means a
     * decision is being requested; {@link Direction#UP}/{@link Direction#DOWN}
     * mean it's already committed to reaching the next floor.
     */
    Direction getDirection();

    /**
     * Floors requested by passengers currently on board, in the order they
     * boarded (a floor may appear more than once if several passengers share
     * the same destination). Empty means the elevator is carrying nobody.
     */
    List<Integer> getDestinationFloors();

    /**
     * True once {@link ElevatorDecision#OPEN_DOORS} has already been executed
     * at the current floor since the elevator arrived here; resets to false as
     * soon as the elevator moves to a different floor. Useful to avoid deciding
     * to open the doors again and again at a floor where nobody new can board
     * (e.g. a full elevator).
     */
    boolean hasOpenedDoorsAtCurrentFloor();

    /**
     * Applies the decision a strategy returned from
     * {@link IElevatorStrategy#chooseNextAction(ElevatorContext)}. Called once
     * per simulation tick for every currently-idle elevator.
     */
    void executeDecision(ElevatorDecision decision);
}
