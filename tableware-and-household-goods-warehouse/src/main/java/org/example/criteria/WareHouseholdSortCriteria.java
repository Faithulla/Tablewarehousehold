package org.example.criteria;

import org.example.entity.WareHousehold;
import org.example.exception.InvalidParameterArgumentsException;

import java.util.Comparator;
import java.util.List;

public class WareHouseholdSortCriteria {

    public void displaySortedWareHousehold(List<WareHousehold> wareHousehold, String sortBy) {
        Comparator<WareHousehold> comparator;
        if ("id".equals(sortBy)) {
            comparator = Comparator.comparingInt(WareHousehold::getId);
        } else if ("name".equals(sortBy)) {
            comparator = Comparator.comparing(WareHousehold::getName);
        } else if ("category".equals(sortBy)) {
            comparator = Comparator.comparing(WareHousehold::getCategory);
        } else if ("price".equals(sortBy)) {
            comparator = Comparator.comparingDouble(WareHousehold::getPrice);
        } else if ("quantity".equals(sortBy)) {
            comparator = Comparator.comparingInt(WareHousehold::getQuantity);
        } else {
            throw new InvalidParameterArgumentsException("Invalid parameter");
        }
        wareHousehold.sort(comparator);
    }

}
