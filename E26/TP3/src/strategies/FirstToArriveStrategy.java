package strategies;

import api.ElevatorContext;
import api.ElevatorDecision;
import api.IElevatorStrategy;

public class FirstToArriveStrategy implements IElevatorStrategy {
    @Override
    public String getName() {
        return "First to Arrive Order";
    }

    @Override
    public ElevatorDecision chooseNextAction(ElevatorContext elevatorContext) {
        return ElevatorDecision.STAY_IDLE;
    }
}
