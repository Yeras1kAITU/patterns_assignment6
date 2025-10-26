package strategies;

public interface DrivingStrategy {
    void accelerate();
    void handleRoadConditions();
    void navigate();
    double calculateFuelConsumption(double distance);
    String getModeName();

    default double formatFuelConsumption(double fuel) {
        return Math.round(fuel * 100.0) / 100.0;
    }
}