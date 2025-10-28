package strategies;

public class OffRoadDrivingStrategy implements DrivingStrategy {
    float fuelEfficiency = 8.0f;

    @Override
    public void accelerate() {
        System.out.println("Off-Road mode: Controlled acceleration with 4WD engaged");
    }

    @Override
    public void handleRoadConditions() {
        System.out.println("Off-Road mode: Adapting to rough terrain, suspension raised");
    }

    @Override
    public void navigate() {
        System.out.println("Off-Road navigation: Calculating terrain-appropriate route");
    }

    @Override
    public float calculateFuelConsumption(float distance) {
        float fuelUsed = distance / fuelEfficiency;
        System.out.printf("Fuel efficiency: %.1f km/l | ", fuelEfficiency);
        return formatFuelConsumption(fuelUsed);
    }

    @Override
    public String getModeName() {
        return "Off-Road Mode";
    }
}