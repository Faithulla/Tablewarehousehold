import org.example.dao.WareHousehold;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.service.ListWareHouseholdService.displaySortedWareHousehold;

public class ListWareHouseholdServiceTest {

    @Test
    public void testDisplaySortedWareHousehold() {
        List<WareHousehold> wareHousehold = new ArrayList<>();
        wareHousehold.add(new WareHousehold(3, "Lamp", "Lighting", 19.99, 15));
        wareHousehold.add(new WareHousehold(1, "Chair", "Furniture", 49.99, 10));
        wareHousehold.add(new WareHousehold(2, "Table", "Furniture", 99.99, 5));

        // Sort by ID
        System.out.println("Sort by ID:");
        displaySortedWareHousehold("id", wareHousehold);

        // Sort by name
        System.out.println("Sort by name:");
        displaySortedWareHousehold("name", wareHousehold);

        // Sort by category
        System.out.println("Sort by category:");
        displaySortedWareHousehold("category", wareHousehold);

        // Sort by price
        System.out.println("Sort by price:");
        displaySortedWareHousehold("price", wareHousehold);

        // Sort by quantity
        System.out.println("Sort by quantity:");
        displaySortedWareHousehold("quantity", wareHousehold);

        // Sort by invalid criterion
        System.out.println("Sort by invalid criterion:");
        displaySortedWareHousehold("invalid", wareHousehold);

    }
}
