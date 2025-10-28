package strategies;

public class SportDrivingStrategy implements DrivingStrategy {
    float fuelEfficiency = 12.0f;

    @Override
    public void accelerate() {
        System.out.println("Sport mode: Rapid acceleration with maximum power");
    }

    @Override
    public void handleRoadConditions() {
        System.out.println("Sport mode: Aggressive handling, maintaining high speed");
    }

    @Override
    public void navigate() {
        System.out.println("Sport navigation: Calculating fastest route");
    }

    @Override
    public float calculateFuelConsumption(float distance) {
        float fuelUsed = distance / fuelEfficiency;
        System.out.printf("Fuel efficiency: %.1f km/l | ", fuelEfficiency);
        return formatFuelConsumption(fuelUsed);
    }

    @Override
    public String getModeName() {
        return "Sport Mode";
    }
}