import java.util.ArrayList;

public class Dealership {

    String name;
    String address;
    String phoneNumber;
    ArrayList<Vehicle> inventory;

    public Dealership() {}

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
        return null;
    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByYear (int min, int max) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByColor (String color) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByType(String type) {
        return null;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {

    }


}
