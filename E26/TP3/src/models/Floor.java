package models;

import java.util.LinkedList;
import java.util.Queue;

public class Floor {
    private final int number;

    private Queue<Passenger> waitingUp;
    private Queue<Passenger> waitingDown;

    public Floor(int number){
        this.number = number;

        waitingUp = new LinkedList<>();
        waitingDown = new LinkedList<>();
    }

    public Queue<Passenger> getWaitingUp(){
        return waitingUp;
    }

    public Queue<Passenger> getWaitingDown(){
        return waitingDown;
    }
}
