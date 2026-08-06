package api;

/**
 * Everything an {@link IElevatorStrategy} needs to make one decision: the
 * building, the specific elevator currently being asked to decide, and the
 * current simulated time (seconds since midnight).
 */
public class ElevatorContext {
	private IBuilding building = null;
	private IElevator elevator = null;
	private long currentTime = 0;

	/**
	 * @param building the building the elevator belongs to
	 * @param elevator the specific elevator this decision is being requested for
	 * @param currentTime current simulated time, in seconds since midnight
	 */
	public ElevatorContext(IBuilding building, IElevator elevator, long currentTime) {
		this.building = building;
		this.elevator = elevator;
		this.currentTime = currentTime;
	}

	/** The building the elevator belongs to. */
	public IBuilding getBuilding() {
		return building;
	}

	/** The elevator this decision is being requested for. */
	public IElevator getElevator() {
		return elevator;
	}

	/** Current simulated time, in seconds since midnight. */
	public long getCurrentTime() {
		return currentTime;
	}
}
