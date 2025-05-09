import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DealershipFileManager {

    public static String filePath = "CarDealership/src/main/resources/car-inventory.csv";

    public Dealership getDealership() {
        Dealership dealership = new Dealership();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] lineParts = input.split("\\|");

                if (lineParts.length > 3 || input.isEmpty()) {
                    continue;
                }

                dealership.setName(lineParts[0]);
                dealership.setAddress(lineParts[1]);
                dealership.setPhoneNumber(lineParts[2]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        System.out.println("Save Dealership");
    }

}
