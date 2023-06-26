package org.example.controller;

import org.example.entity.WareHousehold;
import org.example.service.ListWareHouseholdService;
import org.example.service.SearchWareHouseholdService;

import java.util.List;
import java.util.Scanner;

import static org.example.dao.CsvReader.loadWareHousehold;

public class WareHouseholdController {
    private final String WAREHOUSE_CSV_PATH = "src/main/java/org/example/entity/WareHousehold.csv";

    private final SearchWareHouseholdService householdService = new SearchWareHouseholdService();
    private final ListWareHouseholdService listWareHouseholdService = new ListWareHouseholdService();

    public void manageWareHousehold() {
        List<WareHousehold> wareHousehold = loadWareHousehold(WAREHOUSE_CSV_PATH);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter your choice (1-3): ");
            String action = scanner.nextLine().toUpperCase();
            switch (action) {
                case "1" -> householdService.searchWareHousehold(wareHousehold);
                case "2" -> listWareHouseholdService.displaySortedWareHousehold(wareHousehold);
                case "3" -> {
                    System.out.println("Exiting the warehouse system...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid action. Please enter a valid action (1-3).");
            }
        }
    }
}
