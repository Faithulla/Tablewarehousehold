package org.example.service;

import org.example.criteria.WareHouseholdSearchCriteria;
import org.example.entity.WareHousehold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.view.SearchWareHouseholdView.displaySearchCriterionPrompt;
import static org.example.view.SearchWareHouseholdView.displaySearchValuePrompt;

public class SearchWareHouseholdService {

    private final WareHouseholdSearchCriteria householdSearchCriteria = new WareHouseholdSearchCriteria();

    public void searchWareHousehold(List<WareHousehold> inventory) {
        try {
            Scanner scanner = new Scanner(System.in);
            displaySearchCriterionPrompt();
            String parameter = scanner.nextLine().trim().toLowerCase();
            displaySearchValuePrompt();
            String value = scanner.nextLine().trim().toLowerCase();
            List<WareHousehold> results = new ArrayList<>();
            householdSearchCriteria.search(inventory, parameter, value, results);
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

        } catch (NumberFormatException e) {
            System.out.println("Invalid search value. Please provide a valid value.");
        }
    }


}
