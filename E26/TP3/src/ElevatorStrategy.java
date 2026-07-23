import api.ElevatorContext;
import api.ElevatorDecision;
import api.IElevatorStrategy;

public class ElevatorStrategy implements IElevatorStrategy {
    @Override
    public String getName() {
        return "";
    }

    @Override
    public ElevatorDecision chooseNextAction(ElevatorContext elevatorContext) {
        return null;
    }
}
