package com.example.is413groupproject;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View {
    private VBox layout;
    private TableView<DataEntry> tableView;
    private TextField nameTextField;
    private TextField phoneTextField;
    private TextField addressTextField;
    private TextField emailTextField;
    private TextField secondaryEmailTextField;
    private Button saveButton;
    private Button editButton;
    private Button deleteButton;

    public View() {
        layout = new VBox(10);
        layout.setPrefWidth(400);
        layout.setPrefHeight(300);
        layout.setSpacing(10);
        layout.setStyle("-fx-padding: 20px");

        Label nameLabel = new Label("Name:");
        nameTextField = new TextField();
        Label phoneLabel = new Label("Phone Number:");
        phoneTextField = new TextField();
        Label addressLabel = new Label("Address:");
        addressTextField = new TextField();
        Label emailLabel = new Label("Email:");
        emailTextField = new TextField();
        Label secondaryEmailLabel = new Label("Secondary Email:");
        secondaryEmailTextField = new TextField();
        saveButton = new Button("Save");
        editButton = new Button("Edit");
        deleteButton = new Button("Delete");

        tableView = new TableView<>();
        TableColumn<DataEntry, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<DataEntry, String> phoneColumn = new TableColumn<>("Phone Number");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        TableColumn<DataEntry, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        TableColumn<DataEntry, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<DataEntry, String> secondaryEmailColumn = new TableColumn<>("Secondary Email");
        secondaryEmailColumn.setCellValueFactory(new PropertyValueFactory<>("secondaryEmail"));

        tableView.getColumns().addAll(nameColumn, phoneColumn, addressColumn, emailColumn, secondaryEmailColumn);

        HBox buttonContainer = new HBox(10);
        buttonContainer.getChildren().addAll(saveButton, editButton, deleteButton);

        layout.getChildren().addAll(
                nameLabel, nameTextField, phoneLabel, phoneTextField,
                addressLabel, addressTextField, emailLabel, emailTextField,
                secondaryEmailLabel, secondaryEmailTextField, buttonContainer, tableView
        );
    }

    public VBox getLayout() {
        return layout;
    }

    public TableView<DataEntry> getTableView() {
        return tableView;
    }

    public TextField getNameTextField() {
        return nameTextField;
    }

    public TextField getPhoneTextField() {
        return phoneTextField;
    }

    public TextField getAddressTextField() {
        return addressTextField;
    }

    public TextField getEmailTextField() {
        return emailTextField;
    }

    public TextField getSecondaryEmailTextField() {
        return secondaryEmailTextField;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getEditButton() {
        return editButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }
}
