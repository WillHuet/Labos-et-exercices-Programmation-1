package elevator;

public class SimulationStats {
    private int transportedPassengers;
    private long totalWaitTime;
    private long maximumWaitTime;
    private int stops;
    private int floorsTravelled;
    private long occupancySamples;
    private long occupancyCapacitySamples;

    public void recordPickup(long waitTime) {
        totalWaitTime += waitTime;
        maximumWaitTime = Math.max(maximumWaitTime, waitTime);
    }

    public void recordDelivery() {
        transportedPassengers++;
    }

    public void recordStop() {
        stops++;
    }

    public void recordFloorTravelled() {
        floorsTravelled++;
    }

    public void recordOccupancy(int occupants, int capacity) {
        occupancySamples += occupants;
        occupancyCapacitySamples += capacity;
    }

    public int getTransportedPassengers() {
        return transportedPassengers;
    }

    public double getAverageWaitTime() {
        if (transportedPassengers == 0) {
            return 0.0;
        }
        return (double) totalWaitTime / transportedPassengers;
    }

    public long getMaximumWaitTime() {
        return maximumWaitTime;
    }

    public int getStops() {
        return stops;
    }

    public int getFloorsTravelled() {
        return floorsTravelled;
    }

    public double getAverageOccupancy() {
        if (occupancyCapacitySamples == 0) {
            return 0.0;
        }
        return (double) occupancySamples / occupancyCapacitySamples;
    }

    public void print(String scenarioName, String strategyName) {
        System.out.println("================================");
        System.out.println(scenarioName);
        System.out.println(strategyName);
        System.out.println("================================");
        System.out.println("Passengers transported: " + transportedPassengers);
        System.out.println("Average wait time: " + String.format("%.2f s", getAverageWaitTime()));
        System.out.println("Maximum wait time: " + maximumWaitTime + " s");
        System.out.println("Stops: " + stops);
        System.out.println("Floors travelled: " + floorsTravelled);
        System.out.println("Average occupancy: " + String.format("%.2f", getAverageOccupancy()));
        System.out.println();
    }
}
