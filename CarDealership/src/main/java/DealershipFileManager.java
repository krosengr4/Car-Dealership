import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DealershipFileManager {

    public static String filePath = "CarDealership/src/main/resources/car-inventory.csv";

    public ArrayList<Dealership> getDealership() {

        ArrayList<Dealership> allDealerships = new ArrayList<>();
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String input;

            while ((input = bufferedReader.readLine()) != null) {

                String[] lineParts = input.split("\\|");
                if (lineParts.length > 3 || input.isEmpty()) {
                    continue;
                }

                Dealership dealership = new Dealership(lineParts[0], lineParts[1], lineParts[2]);

                allDealerships.add(dealership);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return allDealerships;
    }

    public void saveDealership(Dealership dealership) {
        System.out.println("Save Dealership");
    }

}
