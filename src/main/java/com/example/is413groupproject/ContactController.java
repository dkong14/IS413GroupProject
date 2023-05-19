package com.example.is413groupproject;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ContactController extends Application {
    private ContactModel contactModel;
    private ContactView contactView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        writeToFile("Alan", "111-222-3333", "SampleAddress", "alan12@email.com", "abook@sls.com");
        contactModel = new ContactModel();
        contactView = new ContactView();

        ObservableList<Contact> contactList = contactModel.getContactList();
        contactView.setContactList(contactList);

        contactView.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Contact newContact = new Contact("", "", "","","");
                contactModel.addContact(newContact);
            }
        });

        contactView.getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Contact selectedContact = contactView.getTableView().getSelectionModel().getSelectedItem();
                if (selectedContact != null) {
                    contactModel.deleteContact(selectedContact);
                }
            }
        });
    }

    // This function takes in strings and writes the input together at the same line.
    // Will probably need to use the toString() method in the StringProperty class to integrate it fully with the
    // program.
    // By default Maven will write to ~/IS413GroupProject/Target/SaveData.txt, if the file does not exist, it will be
    //  created. If it exists then it will just write to it.
    public void writeToFile(String name, String phoneNumber, String address, String primaryEmail, String secondaryEmail){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("SaveData.txt"));
            String writeString = name + "~" + phoneNumber + "~" + address + "~" + primaryEmail + "~" + secondaryEmail;
            writer.write("\n"); // Writes a new line
            writer.write(writeString);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void readFromFile() {
        BufferedReader reader = new BufferedReader(new FileReader("SaveData.txt"));
    }
}
