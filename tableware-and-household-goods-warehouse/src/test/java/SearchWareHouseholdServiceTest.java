import org.example.dao.WareHousehold;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.service.SearchWareHouseholdService.searchWareHousehold;

public class SearchWareHouseholdServiceTest {


    @Test
    public void testSearchWareHousehold() {
        List<WareHousehold> inventory = new ArrayList<>();
        inventory.add(new WareHousehold(1, "Chair", "Furniture", 49.99, 10));
        inventory.add(new WareHousehold(2, "Table", "Furniture", 99.99, 5));
        inventory.add(new WareHousehold(3, "Lamp", "Lighting", 19.99, 15));

        List<WareHousehold> results = new ArrayList<>();

        // Test searching by id
        searchWareHousehold(inventory, "id", "2", results);
        System.out.println("Search by id - Expected: Table");
        printResults(results);
        results.clear();

        // Test searching by name
        searchWareHousehold(inventory, "name", "lamp", results);
        System.out.println("Search by name - Expected: Lamp");
        printResults(results);
        results.clear();

        // Test searching by category
        searchWareHousehold(inventory, "category", "Furniture", results);
        System.out.println("Search by category - Expected: Chair, Table");
        printResults(results);
        results.clear();

        // Test searching by price
        searchWareHousehold(inventory, "price", "19.99", results);
        System.out.println("Search by price - Expected: Lamp");
        printResults(results);
        results.clear();

        // Test searching by quantity
        searchWareHousehold(inventory, "quantity", "10", results);
        System.out.println("Search by quantity - Expected: Chair");
        printResults(results);
        results.clear();

        // Test searching with invalid parameter
        searchWareHousehold(inventory, "invalid", "value", results);
        System.out.println("Search with invalid parameter - Expected: Invalid search parameter.");
        printResults(results);
        results.clear();
    }

    private static void printResults(List<WareHousehold> results) {
        if (results.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        System.out.println("Search results:");
        System.out.println("-----------------------------------------");
        System.out.printf("%-4s %-20s %-25s %-6s %-8s\n", "ID", "Name", "Category", "Price", "Quantity");
        System.out.println("-----------------------------------------");
        for (WareHousehold household : results) {
            System.out.printf("%-4d %-20s %-25s %-6.2f %-8d\n",
                    household.getId(), household.getName(), household.getCategory(),
                    household.getPrice(), household.getQuantity());
        }
        System.out.println("-----------------------------------------");
    }

}
