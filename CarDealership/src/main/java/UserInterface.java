import com.pluralsight.utils.*;

import java.util.ArrayList;

public class UserInterface {

    Dealership dealership;

    public void display() {
        boolean ifContinue = true;

        while (ifContinue) {
            String userMenuChoice = menuChoice();
            init();

            switch (userMenuChoice) {
                case "7" -> processAllVehiclesRequest();
                case "99" -> ifContinue = false;
            }
        }
    }

    private String menuChoice() {
        System.out.println("\n\tOPTIONS");
        Design.designLine(20, false);
        System.out.println("""
                1 - Find Car by Price
                2 - Find Car by Make and Model
                3 - Find Car by Year
                4 - Find Car by Color
                5 - Find Car by Mileage
                6 - Find Cars by Vehicle Type
                7 - Show All Vehicles
                8 - Add a Vehicle
                9 - Remove a Vehicle
                99 - Exit
                """);

        return UserPrompt.promptGetUserInput("What would you like to do?: ").trim();
    }

    private void init() {
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership();
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("There are no vehicles...");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.printf("VIN: %d | Year: %d | Make: %s | Model: %s | Color: %s | Total Mileage: %d " +
                                "| Price: $%.2f", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
            }
        }
        UserPrompt.pauseApp();
    }

    private void processAllVehiclesRequest() {
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }


}
