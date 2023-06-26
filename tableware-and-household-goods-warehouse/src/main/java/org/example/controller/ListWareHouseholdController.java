package org.example.controller;

import org.example.dao.WareHousehold;

import java.util.List;
import java.util.Scanner;

import static org.example.service.ListWareHouseholdService.displaySortedWareHousehold;
import static org.example.view.ListWareHouseholdView.displaySortOptions;

public class ListWareHouseholdController {

    public static void displayWareHousehold(List<WareHousehold> wareHouseholds) {
        Scanner scanner = new Scanner(System.in);
        displaySortOptions();
        String order = scanner.nextLine().trim().toLowerCase();
        displaySortedWareHousehold(order, wareHouseholds);
    }
}
