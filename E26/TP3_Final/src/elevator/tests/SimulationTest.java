package elevator.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import elevator.Simulation;
import elevator.SimulationStats;
import elevator.scenarios.CommercialBuildingScenario;
import elevator.scenarios.SkyscraperScenario;
import elevator.strategies.ScanStrategy;
import org.junit.jupiter.api.Test;

import elevator.api.ElevatorContext;
import elevator.api.ElevatorDecision;
import elevator.api.IBuilding;
import elevator.api.IElevator;
import elevator.scenarios.SmallOfficeScenario;
import elevator.strategies.BalancedUrgencyStrategy;
import elevator.strategies.FIFOStrategy;

public class SimulationTest {
    // TESTS ON EXPECTED VALUES
    @Test
    public void smallOfficeScenarioHasExpectedValues() {
        SmallOfficeScenario scenario = new SmallOfficeScenario();

        assertEquals(3, scenario.getFloorCount());
        assertEquals(1, scenario.getElevatorCount());
        assertEquals(45, scenario.getEmployeeCount());
    }

    @Test
    public void commercialOfficeScenarioHasExpectedValues() {
        CommercialBuildingScenario scenario = new CommercialBuildingScenario();

        assertEquals(12, scenario.getFloorCount());
        assertEquals(3, scenario.getElevatorCount());
        assertEquals(350, scenario.getEmployeeCount());
    }

    @Test
    public void SkyscraperScenarioHasExpectedValues() {
        SkyscraperScenario scenario = new SkyscraperScenario();

        assertEquals(40, scenario.getFloorCount());
        assertEquals(12, scenario.getElevatorCount());
        assertEquals(3000, scenario.getEmployeeCount());
    }

    // TESTS ON EXPECTED TRIPS
    @Test
    public void smallOfficeTransportsFourTripsPerEmployee() {
        Simulation simulation = new Simulation(new SmallOfficeScenario(), new FIFOStrategy());
        SimulationStats stats = simulation.run();

        assertEquals(180, stats.getTransportedPassengers());
        assertTrue(stats.getStops() > 0);
        assertTrue(stats.getFloorsTravelled() > 0);
    }

    @Test
    public void commercialScenarioTransportsFourTripsPerEmployee() {
        Simulation simulation = new Simulation(
                new CommercialBuildingScenario(),
                new FIFOStrategy()
        );

        SimulationStats stats = simulation.run();

        assertEquals(350 * 4, stats.getTransportedPassengers());
    }

    @Test
    public void SkyscraperScenarioTransportsFourTripsPerEmployee() {
        Simulation simulation = new Simulation(
                new SkyscraperScenario(),
                new FIFOStrategy()
        );

        SimulationStats stats = simulation.run();

        assertEquals(3000 * 4, stats.getTransportedPassengers());
    }

    // TESTS ON STRATEGIES
    // PERSONAL_STRATEGY
    @Test
    public void balancedStrategyOpensDoorsWhenPassengerWaitsAtCurrentFloor() {
        BalancedUrgencyStrategy strategy = new BalancedUrgencyStrategy();
        IBuilding building = new TestBuilding();
        IElevator elevator = new TestElevator();

        ElevatorDecision decision = strategy.chooseNextAction(
                new ElevatorContext(building, elevator, 8 * 3600)
        );

        assertEquals(ElevatorDecision.OPEN_DOORS, decision);
    }

    //FIFO_STRATEGY
    @Test
    public void fifoStrategyDoesNotStayIdleWhenPassengerIsWaiting() {
        FIFOStrategy strategy = new FIFOStrategy();
        IBuilding building = new TestBuilding();
        IElevator elevator = new TestElevator();

        ElevatorDecision decision = strategy.chooseNextAction(
                new ElevatorContext(building, elevator, 8 * 3600)
        );

        assertTrue(
                decision == ElevatorDecision.OPEN_DOORS
                        || decision == ElevatorDecision.MOVE_UP
                        || decision == ElevatorDecision.MOVE_DOWN
        );
    }

    //SCAN_STRATEGY
    @Test
    public void scanStrategyMovesUpWhenDemandExistsAbove() {
        ScanStrategy strategy = new ScanStrategy();
        IBuilding building = new TestBuilding();
        IElevator elevator = new TestElevator();

        ElevatorDecision decision = strategy.chooseNextAction(
                new ElevatorContext(building, elevator, 8 * 3600)
        );

        assertEquals(ElevatorDecision.OPEN_DOORS, decision);
    }

    // TEST ON STATS
    @Test
    public void simulationProducesRequiredStatistics() {
        Simulation simulation = new Simulation(
                new SmallOfficeScenario(),
                new BalancedUrgencyStrategy()
        );

        SimulationStats stats = simulation.run();

        assertTrue(stats.getTransportedPassengers() > 0);
        assertTrue(stats.getAverageWaitTime() >= 0);
        assertTrue(stats.getMaximumWaitTime() >= 0);
        assertTrue(stats.getStops() > 0);
        assertTrue(stats.getFloorsTravelled() > 0);
        assertTrue(stats.getAverageOccupancy() >= 0);
    }
}
