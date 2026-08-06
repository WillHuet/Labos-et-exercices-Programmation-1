
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import api.ElevatorContext;
import api.ElevatorDecision;
import api.IBuilding;
import api.IElevator;
import scenarios.SmallOfficeScenario;
import strategies.BalancedUrgencyStrategy;
import strategies.FIFOStrategy;

public class SimulationTest {
    @Test
    public void smallOfficeTransportsFourTripsPerEmployee() {
        Simulation simulation = new Simulation(new SmallOfficeScenario(), new FIFOStrategy());
        SimulationStats stats = simulation.run();

        assertEquals(180, stats.getTransportedPassengers());
        assertTrue(stats.getStops() > 0);
        assertTrue(stats.getFloorsTravelled() > 0);
    }

    @Test
    public void personalStrategyOpensDoorsWhenPassengerWaitsAtCurrentFloor() {
        BalancedUrgencyStrategy strategy = new BalancedUrgencyStrategy();
        IBuilding building = new TestBuilding();
        IElevator elevator = new TestElevator();

        ElevatorDecision decision = strategy.chooseNextAction(new ElevatorContext(building, elevator, 8 * 3600));

        assertEquals(ElevatorDecision.OPEN_DOORS, decision);
    }
}
