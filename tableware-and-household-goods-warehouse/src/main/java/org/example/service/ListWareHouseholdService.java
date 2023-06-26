package org.example.service;

import org.example.criteria.WareHouseholdSortCriteria;
import org.example.entity.WareHousehold;

import java.util.List;
import java.util.Scanner;

import static org.example.view.ListWareHouseholdView.displaySortOptions;

public class ListWareHouseholdService {

    private final WareHouseholdSortCriteria sortCriteria = new WareHouseholdSortCriteria();
    public void displaySortedWareHousehold(List<WareHousehold> wareHousehold) {
        Scanner scanner = new Scanner(System.in);
        displaySortOptions();
        String sortBy = scanner.nextLine().trim().toLowerCase();
        sortCriteria.displaySortedWareHousehold(wareHousehold,sortBy);
        System.out.println("WareHousehold list (sorted by " + sortBy + "):");
        System.out.println("-------------------~-------------------------------");
        System.out.printf("%-4s %-20s %-25s %-6s %-8s\n", "ID", "Name", "Category", "Price", "Quantity");
        System.out.println("--------------------------------------------------");
        for (WareHousehold household : wareHousehold) {
            System.out.printf("%-4d %-20s %-25s %-6.2f %-8d\n",
                    household.getId(), household.getName(), household.getCategory(),
                    household.getPrice(), household.getQuantity());
        }
        System.out.println("--------------------------------------------------");
    }
}
