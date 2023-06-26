import org.example.entity.WareHousehold;
import org.example.exception.InvalidParameterArgumentsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.dao.CsvReader.loadWareHousehold;

public class CsvReaderTest {
    @Test
    void testLoadWareHousehold() {
        // Test data
        String testFilePath = "src/main/java/org/example/entity/WareHousehold.csv";
        List<WareHousehold> expectedInventory = List.of(
                new WareHousehold(1, "Knives", "Flatware", 10.00, 50),
                new WareHousehold(2, "Spoons", "Flatware", 5.00, 100),
                new WareHousehold(3, "Forks", "Flatware", 15.00, 30),
                new WareHousehold(4, "Plates", "Dinnerware", 50.00, 20),
                new WareHousehold(5, "Bowls", "Dinnerware", 8.00, 40),
                new WareHousehold(6, "Cups", "Dinnerware", 4.00, 60),
                new WareHousehold(7, "Water glasses", "Glassware", 12.00, 25),
                new WareHousehold(8, "Wine glasses", "Glassware", 40.00, 10),
                new WareHousehold(9, "HarmonyServe", "Serve ware", 30.00, 15),
                new WareHousehold(10, "GourmetServe", "Serve ware", 20.00, 5)
        );

        // Call the method
        List<WareHousehold> actualInventory = null;
        try {
            actualInventory = loadWareHousehold(testFilePath);
        } catch (InvalidParameterArgumentsException e) {
            Assertions.fail("Unexpected exception: " + e.getMessage());
        }

        // Assert the results
        Assertions.assertEquals(expectedInventory.size(), actualInventory.size());
        for (int i = 0; i < expectedInventory.size(); i++) {
            WareHousehold expectedItem = expectedInventory.get(i);
            WareHousehold actualItem = actualInventory.get(i);
            Assertions.assertEquals(expectedItem.getId(), actualItem.getId());
            Assertions.assertEquals(expectedItem.getName(), actualItem.getName());
            Assertions.assertEquals(expectedItem.getCategory(), actualItem.getCategory());
            Assertions.assertEquals(expectedItem.getPrice(), actualItem.getPrice(), 0.001);
            Assertions.assertEquals(expectedItem.getQuantity(), actualItem.getQuantity());
        }
    }
}
