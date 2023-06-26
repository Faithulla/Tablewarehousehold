package org.example.dao;

import org.example.entity.WareHousehold;
import org.example.exception.InvalidParameterArgumentsException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<WareHousehold> loadWareHousehold(String path) {
        List<WareHousehold> inventory = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String category = fields[2];
                double price = Double.parseDouble(fields[3]);
                int quantity = Integer.parseInt(fields[4]);
                WareHousehold item = new WareHousehold(id, name, category, price, quantity);
                inventory.add(item);
            }
        } catch (IOException e) {
            System.err.println("Error reading WareHousehold.csv file: " + e.getMessage());
            throw new InvalidParameterArgumentsException("Invalid path for WareHousehold.csv");
        }
        return inventory;
    }
}
