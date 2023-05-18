/*
File Name: ContactMain.javaa
Author: Dexter Kong and Yabi Gruga
Purpose: The main file
 */

package com.example.is413groupproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ContactMain extends Application {

    Stage window;
    TableView<Contact> myTable;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;

        // Create Columns
        TableColumn<Contact, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(300);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Contact, String> phoneNumberColumn = new TableColumn<>("Phone Number");
        phoneNumberColumn.setMinWidth(300);
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        myTable = new TableView<>();
        myTable.setItems(getContact()); // Loads Contact info from getContact() and sets the value of the table's "Items" property
        myTable.getColumns().addAll(nameColumn, phoneNumberColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(myTable);

        Scene scene = new Scene(vBox);
        window.setTitle("Phone Book Editor");
        window.setScene(scene);
        window.show();
    }

    // Loads the contact information
    public ObservableList<Contact> getContact() {
        ObservableList<Contact> contacts = FXCollections.observableArrayList();
        contacts.add(new Contact("TestName", "TestNumber")); // Filler data, should be a loop for final ver.
        return contacts;
    }

}
