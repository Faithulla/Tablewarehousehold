package org.example.controller;

import org.example.dao.WareHousehold;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.service.SearchWareHouseholdService.searchWareHousehold;
import static org.example.view.SearchWareHouseholdView.displaySearchCriterionPrompt;
import static org.example.view.SearchWareHouseholdView.displaySearchValuePrompt;

public class SearchWareHouseholdController {
    public static void searchProducts(List<WareHousehold> wareHouseholds) {
        Scanner scanner = new Scanner(System.in);
        displaySearchCriterionPrompt();
        String parameter = scanner.nextLine().trim().toLowerCase();
        displaySearchValuePrompt();
        String value = scanner.nextLine().trim().toLowerCase();
        List<WareHousehold> results = new ArrayList<>();
        searchWareHousehold(wareHouseholds, parameter, value, results);
    }

}
