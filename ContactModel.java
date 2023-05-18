package com.example.project_is413;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContactModel {
    private ObservableList<Contact> contactList;

    public ContactModel() {
        contactList = FXCollections.observableArrayList();
    }

    public ObservableList<Contact> getContactList() {
        return contactList;
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public void deleteContact(Contact contact) {
        contactList.remove(contact);
    }
}

class Contact {
    private SimpleStringProperty name;
    private SimpleStringProperty phoneNumber;
    private SimpleStringProperty address;
    private SimpleStringProperty primaryEmail;
    private SimpleStringProperty secondaryEmail;

    public Contact(String name,String phoneNumber, String address,String primaryEmail, String secondaryEmail) {
        this.name = new SimpleStringProperty(name);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.address = new SimpleStringProperty(address);
        this.primaryEmail = new SimpleStringProperty(primaryEmail);
        this.secondaryEmail = new SimpleStringProperty(secondaryEmail);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }
    public String getPrimaryEmail() {
        return primaryEmail.get();
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail.set(primaryEmail);
    }

    public String getSecondaryEmail() {
        return secondaryEmail.get();
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail.set(secondaryEmail);
    }
}


