package com.example.is413groupproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Model {
    private static final String FILE_PATH = "data.txt";
    private ObservableList<DataEntry> dataEntries;

    public Model() {
        dataEntries = FXCollections.observableArrayList();
    }

    public ObservableList<DataEntry> getDataEntries() {
        return dataEntries;
    }

    public void saveDataToFile(DataEntry dataEntry) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            writer.println("Name: " + dataEntry.getName());
            writer.println("Phone Number: " + dataEntry.getPhoneNumber());
            writer.println("Address: " + dataEntry.getAddress());
            writer.println("Email: " + dataEntry.getEmail());
            writer.println("Secondary Email: " + dataEntry.getSecondaryEmail());
            writer.println();
            System.out.println("Data saved to file: " + dataEntry.getName());
        } catch (IOException e) {
            System.out.println("An error occurred while saving data to file: " + e.getMessage());
        }
    }

    public void updateDataEntry(DataEntry oldEntry, DataEntry newEntry) {
        int index = dataEntries.indexOf(oldEntry);
        if (index != -1) {
            dataEntries.set(index, newEntry);
        }
    }

    public void deleteDataEntry(DataEntry dataEntry) {
        dataEntries.remove(dataEntry);
    }
}
