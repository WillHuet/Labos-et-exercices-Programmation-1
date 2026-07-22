package api;

/**
 * A pluggable elevator dispatch algorithm. The simulation calls
 * {@link #chooseNextAction(ElevatorContext)} once per tick for every elevator
 * that is currently idle, and applies whatever {@link ElevatorDecision} it
 * returns. A single instance is shared across every elevator in the building,
 * so any per-elevator state a strategy needs to remember (e.g. which way it
 * was last sweeping) must be keyed by {@link IElevator#getId()}.
 */
public interface IElevatorStrategy {

	/** Display name used when printing this run's statistics. */
	String getName();

	/**
	 * Decides what {@code elevatorContext.getElevator()} should do next, given
	 * the current state of the building and the elevator itself. Only called
	 * while that elevator is idle (see {@link IElevator#getDirection()}).
	 */
	ElevatorDecision chooseNextAction(ElevatorContext elevatorContext);
}
