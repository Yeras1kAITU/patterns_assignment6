import strategies.*;
import java.util.Map;

public class Car {
    private DrivingStrategy drivingStrategy = new EcoDrivingStrategy(); // default strategy

    // Map для хранения стратегий - устранение switch
    private static final Map<DrivingMode, DrivingStrategy> strategies = Map.of(
            DrivingMode.ECO, new EcoDrivingStrategy(),
            DrivingMode.SPORT, new SportDrivingStrategy(),
            DrivingMode.OFF_ROAD, new OffRoadDrivingStrategy()
    );

    public void setDrivingStrategy(DrivingStrategy strategy) {
        this.drivingStrategy = strategy;
        System.out.println("✓ Driving mode changed to: " + strategy.getModeName());
    }

    /**
     * Type-safe mode changing using Map - без switch
     */
    public void changeMode(DrivingMode mode) {
        DrivingStrategy strategy = strategies.get(mode);
        if (strategy != null) {
            setDrivingStrategy(strategy);
        } else {
            // Fallback to default if mode not found (should not happen with enum)
            setDrivingStrategy(new EcoDrivingStrategy());
        }
    }

    public void drive(double distance) {
        System.out.println("\n=== Starting journey ===");
        System.out.println("Current mode: " + drivingStrategy.getModeName());

        drivingStrategy.accelerate();
        drivingStrategy.handleRoadConditions();
        drivingStrategy.navigate();

        System.out.print("Fuel calculation: ");
        double fuelUsed = drivingStrategy.calculateFuelConsumption(distance);
        System.out.printf("Fuel consumed for %.1f km: %.2f liters%n", distance, fuelUsed);

        System.out.println("=== Journey completed ===\n");
    }

    public String getCurrentMode() {
        return drivingStrategy.getModeName();
    }

    /**
     * Вспомогательный метод для получения количества доступных стратегий
     */
    public static int getAvailableStrategiesCount() {
        return strategies.size();
    }
}