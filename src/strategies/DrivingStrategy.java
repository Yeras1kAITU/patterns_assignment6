package strategies;

public interface DrivingStrategy {
    void accelerate();
    void handleRoadConditions();
    void navigate();
    float calculateFuelConsumption(float distance);
    String getModeName();

    default float formatFuelConsumption(float fuel) {
        return Math.round(fuel * 100.0f) / 100.0f;
    }
}