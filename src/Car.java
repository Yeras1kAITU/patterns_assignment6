import strategies.*;
import java.util.Map;
import java.util.Objects;

public class Car {
    private DrivingStrategy drivingStrategy = new EcoDrivingStrategy();

    private static final Map<DrivingMode, DrivingStrategy> strategies = Map.of(
            DrivingMode.ECO, new EcoDrivingStrategy(),
            DrivingMode.SPORT, new SportDrivingStrategy(),
            DrivingMode.OFF_ROAD, new OffRoadDrivingStrategy()
    );

    public void setDrivingStrategy(DrivingStrategy strategy) {
        this.drivingStrategy = strategy;
        System.out.println("✓ Driving mode changed to: " + strategy.getModeName());
    }

    public void changeMode(DrivingMode mode) {
        DrivingStrategy strategy = strategies.get(mode);
        setDrivingStrategy(Objects.requireNonNullElseGet(strategy, () -> new EcoDrivingStrategy()));
    }

    public void drive(float distance) {
        System.out.println("\n=== Starting journey ===");
        System.out.println("Current mode: " + drivingStrategy.getModeName());

        drivingStrategy.accelerate();
        drivingStrategy.handleRoadConditions();
        drivingStrategy.navigate();

        System.out.print("Fuel calculation: ");
        float fuelUsed = drivingStrategy.calculateFuelConsumption(distance);
        System.out.printf("Fuel consumed for %.1f km: %.2f liters%n", distance, fuelUsed);

        System.out.println("=== Journey completed ===\n");
    }
}