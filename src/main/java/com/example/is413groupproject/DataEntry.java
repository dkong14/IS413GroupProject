package com.example.is413groupproject;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataEntry {
    private StringProperty name;
    private StringProperty phoneNumber;
    private StringProperty address;
    private StringProperty email;
    private StringProperty secondaryEmail;

    public DataEntry(String name, String phoneNumber, String address, String email, String secondaryEmail) {
        this.name = new SimpleStringProperty(name);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.address = new SimpleStringProperty(address);
        this.email = new SimpleStringProperty(email);
        this.secondaryEmail = new SimpleStringProperty(secondaryEmail);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getSecondaryEmail() {
        return secondaryEmail.get();
    }

    public StringProperty secondaryEmailProperty() {
        return secondaryEmail;
    }
}

