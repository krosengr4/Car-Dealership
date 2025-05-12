import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dealership {

    String name;
    String address;
    String phoneNumber;
    ArrayList<Vehicle> inventory;

    public Dealership() {
    }

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        inventory = new ArrayList<>();
    }

    //region getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //endregion

    public ArrayList<Vehicle> getVehiclesByPrice(int min, int max) {

        ArrayList<Vehicle> inventory = getAllVehicles();
        ArrayList<Vehicle> vehiclesByPrice = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() > min && vehicle.getPrice() < max) {
                vehiclesByPrice.add(vehicle);
            }
        }

        return vehiclesByPrice;
    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model) {

        ArrayList<Vehicle> inventory = getAllVehicles();
        ArrayList<Vehicle> vehiclesByMakeModel = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                vehiclesByMakeModel.add(vehicle);
            }
        }

        return vehiclesByMakeModel;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> inventory = getAllVehicles();
        ArrayList<Vehicle> vehiclesByYear = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() > min && vehicle.getYear() < max) {
                vehiclesByYear.add(vehicle);
            }
        }
        return vehiclesByYear;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByType(String type) {
        return null;
    }

    public ArrayList<Vehicle> getAllVehicles() {

        inventory = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(DealershipFileManager.filePath));
            String input;

            while ((input = bufferedReader.readLine()) != null) {
                String[] lineParts = input.split("\\|");

                if (lineParts.length < 5 || input.isEmpty()) {
                    continue;
                }
                int vin = Integer.parseInt(lineParts[0]);
                int year = Integer.parseInt(lineParts[1]);
                String make = lineParts[2];
                String model = lineParts[3];
                String vehicleType = lineParts[4];
                String color = lineParts[5];
                int odometer = Integer.parseInt(lineParts[6]);
                double price = Double.parseDouble(lineParts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                inventory.add(vehicle);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {

    }

//        inventory = new ArrayList<>();
//
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(DealershipFileManager.filePath));
//            String input;
//
//            while ((input = br.readLine()) != null) {
//                String[] lineParts = input.split("\\|");
//
//                if (lineParts.length < 5 || input.isEmpty()) {
//                    continue;
//                }
//
//                int vin = Integer.parseInt(lineParts[0]);
//                int year = Integer.parseInt(lineParts[1]);
//                String make = lineParts[2];
//                String model = lineParts[3];
//                String vehicleType = lineParts[4];
//                String color = lineParts[5];
//                int odometer = Integer.parseInt(lineParts[6]);
//                double price = Double.parseDouble(lineParts[7]);
//
//                if (min < price && max > price) {
//                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
//                    inventory.add(vehicle);
//                }
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return inventory;

}
