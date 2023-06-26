import org.example.criteria.WareHouseholdSearchCriteria;
import org.example.entity.WareHousehold;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WareHouseholdSearchCriteriaTest {

    @Test
    public void testSearchById() {
        // Arrange
        List<WareHousehold> inventory = new ArrayList<>();
        WareHouseholdSearchCriteria searchCriteria = new WareHouseholdSearchCriteria();
        inventory.add(new WareHousehold(1, "Item1", "Category1", 10.0, 5));
        inventory.add(new WareHousehold(2, "Item2", "Category2", 20.0, 10));
        inventory.add(new WareHousehold(3, "Item3", "Category1", 15.0, 8));

        List<WareHousehold> results = new ArrayList<>();

        // Act
        searchCriteria.search(inventory, "id", "2", results);

        // Assert
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(2, results.get(0).getId());
    }

    @Test
    public void testSearchByName() {
        // Arrange
        List<WareHousehold> inventory = new ArrayList<>();
        WareHouseholdSearchCriteria searchCriteria = new WareHouseholdSearchCriteria();
        inventory.add(new WareHousehold(1, "Item1", "Category1", 10.0, 5));
        inventory.add(new WareHousehold(2, "Item2", "Category2", 20.0, 10));
        inventory.add(new WareHousehold(3, "Item3", "Category1", 15.0, 8));

        List<WareHousehold> results = new ArrayList<>();

        // Act
        searchCriteria.search(inventory, "name", "item", results);

        // Assert
        Assertions.assertEquals(3, results.size());
        Assertions.assertEquals("Item1", results.get(0).getName());
        Assertions.assertEquals("Item2", results.get(1).getName());
        Assertions.assertEquals("Item3", results.get(2).getName());
    }

}
