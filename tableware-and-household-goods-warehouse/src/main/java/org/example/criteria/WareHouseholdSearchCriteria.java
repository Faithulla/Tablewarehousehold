package org.example.criteria;

import org.example.entity.WareHousehold;
import org.example.exception.InvalidParameterArgumentsException;

import java.util.List;

public class WareHouseholdSearchCriteria {

    public void search(List<WareHousehold> inventory, String searchParameter, String searchValue, List<WareHousehold> results) {
        for (WareHousehold wareHousehold : inventory) {
            switch (searchParameter) {
                case "id":
                    if (wareHousehold.getId() == Integer.parseInt(searchValue)) {
                        results.add(wareHousehold);
                    }
                    break;
                case "name":
                    if (wareHousehold.getName().toLowerCase().contains(searchValue.toLowerCase())) {
                        results.add(wareHousehold);
                    }
                    break;
                case "category":
                    if (wareHousehold.getCategory().toLowerCase().contains(searchValue.toLowerCase())) {
                        results.add(wareHousehold);
                    }
                    break;
                case "price":
                    if (wareHousehold.getPrice() == Double.parseDouble(searchValue)) {
                        results.add(wareHousehold);
                    }
                    break;
                case "quantity":
                    if (wareHousehold.getQuantity() == Integer.parseInt(searchValue)) {
                        results.add(wareHousehold);
                    }
                    break;
                default:
                    throw new InvalidParameterArgumentsException("Invalid search parameter.");
            }
        }
    }
}

