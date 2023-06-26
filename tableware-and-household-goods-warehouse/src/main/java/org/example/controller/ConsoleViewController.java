package org.example.controller;

import org.example.dao.WareHousehold;

import java.util.List;
import java.util.Scanner;

import static org.example.controller.ListWareHouseholdController.displayWareHousehold;
import static org.example.controller.SearchWareHouseholdController.searchProducts;
import static org.example.service.LoadWareHouseholdDaoService.loadWareHousehold;

public class ConsoleViewController {

    public static void manageWareHousehold() {
        List<WareHousehold> wareHousehold = loadWareHousehold();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter your choice (1-3): ");
            String action = scanner.nextLine().toUpperCase();
            switch (action) {
                case "1" -> searchProducts(wareHousehold);
                case "2" -> displayWareHousehold(wareHousehold);
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
