import java.util.Scanner;

public class DrivingDemo {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();

        System.out.println("Car Driving System");
        displayAvailableModes();

        DrivingMode selectedMode = selectDrivingMode(scanner);
        car.changeMode(selectedMode);

        System.out.print("Enter distance in km: ");
        double distance = scanner.nextDouble();
        scanner.nextLine();

        car.drive(distance);

        System.out.print("Do you want to try another mode? (yes[y]/no): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
            DrivingMode newMode = selectDrivingMode(scanner);
            car.changeMode(newMode);
            car.drive(distance);
        }

        System.out.println("Thank you for using Car Driving System!");
        scanner.close();
    }

    private static void displayAvailableModes() {
        System.out.println("Available driving modes:");
        System.out.println("1-Eco Mode (default)");
        System.out.println("2-Sport Mode");
        System.out.println("3-Off-Road Mode");
    }

    private static DrivingMode selectDrivingMode(Scanner scanner) {
        System.out.print("Choose driving mode (1-3): ");
        String input = scanner.nextLine().trim();

        return switch (input) {
            case "1" -> DrivingMode.ECO;
            case "2" -> DrivingMode.SPORT;
            case "3" -> DrivingMode.OFF_ROAD;
            default -> {
                System.out.println("Invalid input. Using default Eco Mode.");
                yield DrivingMode.ECO;
            }
        };
    }
}