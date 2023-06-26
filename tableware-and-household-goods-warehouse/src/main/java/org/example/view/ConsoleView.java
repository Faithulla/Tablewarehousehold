package org.example.view;


import org.example.controller.WareHouseholdController;

public class ConsoleView {

    private final WareHouseholdController householdController = new WareHouseholdController();
    public static void main(String[] args) {
        System.out.println("Tableware and Household Goods Warehouse (Created on May 28, 2023)");
        System.out.println("Developer: Fayzulla Shokirov (Fayzulla_Shokirov@student.itpu.uz)");

        System.out.println("\nMenu Choices:");
        System.out.println("1. Search for warehouse items");
        System.out.println("2. Display all warehouse items");
        System.out.println("3. Quit the program");
        ConsoleView view = new ConsoleView();
        view.action();
    }

    public void action(){
        householdController.manageWareHousehold();
    }



}
