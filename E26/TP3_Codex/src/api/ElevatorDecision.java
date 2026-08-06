package api;

/** What a strategy wants an elevator to do next; see {@link IElevator#executeDecision(ElevatorDecision)}. */
public enum ElevatorDecision
{
    MOVE_UP,
    MOVE_DOWN,
    OPEN_DOORS,
    STAY_IDLE
}
