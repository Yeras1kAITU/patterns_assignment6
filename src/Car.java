import strategies.DrivingStrategy;

public class DrivingContext {
    private String driverName;
    private double totalDistance;
    private DrivingStrategy currentStrategy;

    public DrivingContext(String driverName) {
        this.driverName = driverName;
        this.totalDistance = 0;
    }

    public void setDrivingStrategy(DrivingStrategy strategy) {
        this.currentStrategy = strategy;
        System.out.println(driverName + " switched to: " + strategy.getDrivingModeName());
    }

    public void executeDrive(String destination, double distance) {
        if (currentStrategy == null) {
            System.out.println("Please select a driving strategy first");
            return;
        }

        System.out.println("\n=== Starting Journey to " + destination + " ===");

        // Demonstrate strategy behaviors
        currentStrategy.accelerate();
        currentStrategy.handleRoadConditions();
        currentStrategy.navigate(destination);

        double fuelConsumed = currentStrategy.calculateFuelEfficiency(distance);
        totalDistance += distance;

        System.out.println("Journey completed: " + distance + " km");
        System.out.println("Estimated fuel consumed: " + String.format("%.2f", fuelConsumed) + " liters");
        System.out.println("Total distance driven: " + totalDistance + " km");
    }

    public void demonstrateCurrentStrategy() {
        if (currentStrategy != null) {
            System.out.println("\n=== Demonstrating " + currentStrategy.getDrivingModeName() + " ===");
            currentStrategy.accelerate();
            currentStrategy.handleRoadConditions();
        } else {
            System.out.println("No driving strategy selected");
        }
    }

    // Getters
    public String getDriverName() { return driverName; }
    public double getTotalDistance() { return totalDistance; }
    public String getCurrentStrategyName() {
        return currentStrategy != null ? currentStrategy.getDrivingModeName() : "None";
    }
}