package elevator;

import java.util.Arrays;
import java.util.List;

import elevator.api.IElevatorStrategy;
import elevator.api.IScenario;
import elevator.scenarios.CommercialBuildingScenario;
import elevator.scenarios.SkyscraperScenario;
import elevator.scenarios.SmallOfficeScenario;
import elevator.strategies.BalancedUrgencyStrategy;
import elevator.strategies.FIFOStrategy;
import elevator.strategies.ScanStrategy;

public class Main {
    public static void main(String[] args) {
        List<IScenario> scenarios = Arrays.asList(
                new SmallOfficeScenario(),
                new CommercialBuildingScenario(),
                new SkyscraperScenario());

        for (IScenario scenario : scenarios) {
            List<IElevatorStrategy> strategies = Arrays.asList(
                    new FIFOStrategy(),
                    new ScanStrategy(),
                    new BalancedUrgencyStrategy());

            for (IElevatorStrategy strategy : strategies) {
                Simulation simulation = new Simulation(scenario, strategy);
                SimulationStats stats = simulation.run();
                stats.print(scenario.getName(), strategy.getName());
            }
        }
    }
}
