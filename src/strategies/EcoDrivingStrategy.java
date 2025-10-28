package strategies;

public class EcoDrivingStrategy implements DrivingStrategy {
    float fuelEfficiency = 18.5f;

    @Override
    public void accelerate() {
        System.out.println("Eco mode: Smooth acceleration for optimal fuel efficiency");
    }

    @Override
    public void handleRoadConditions() {
        System.out.println("Eco mode: Maintaining steady pace, anticipating traffic flow");
    }

    @Override
    public void navigate() {
        System.out.println("Eco navigation: Calculating most fuel-efficient route");
    }

    @Override
    public float calculateFuelConsumption(float distance) {
        float fuelUsed = distance / fuelEfficiency;
        System.out.printf("Fuel efficiency: %.1f km/l | ", fuelEfficiency);
        return formatFuelConsumption(fuelUsed);
    }

    @Override
    public String getModeName() {
        return "Eco Mode";
    }
}