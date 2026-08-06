import java.util.Arrays;
import java.util.List;

import api.IElevatorStrategy;
import api.IScenario;
import scenarios.CommercialBuildingScenario;
import scenarios.SkyscraperScenario;
import scenarios.SmallOfficeScenario;
import strategies.BalancedUrgencyStrategy;
import strategies.FIFOStrategy;
import strategies.ScanStrategy;

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
