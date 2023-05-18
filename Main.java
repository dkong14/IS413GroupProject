package com.example.project_;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private ObservableList<Contact> contactList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        contactList = FXCollections.observableArrayList();

        TableView<Contact> tableView = new TableView<>();
        tableView.setEditable(true);

        TableColumn<Contact, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(event -> {
            Contact contact = event.getTableView().getItems().get(event.getTablePosition().getRow());
            contact.setName(event.getNewValue());
        });

        TableColumn<Contact, String> phoneColumn = new TableColumn<>("Phone Number");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneColumn.setOnEditCommit(event -> {
            Contact contact = event.getTableView().getItems().get(event.getTablePosition().getRow());
            contact.setPhoneNumber(String.valueOf(Integer.parseInt(event.getNewValue())));
        });
        TableColumn<Contact, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        addressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        addressColumn.setOnEditCommit(event -> {
            Contact contact = event.getTableView().getItems().get(event.getTablePosition().getRow());
            contact.setAddress(String.valueOf(Integer.parseInt(event.getNewValue())));
        });
        TableColumn<Contact, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setOnEditCommit(event -> {
            Contact contact = event.getTableView().getItems().get(event.getTablePosition().getRow());
            contact.setEmail(String.valueOf(Integer.parseInt(event.getNewValue())));
        });

        tableView.getColumns().addAll(nameColumn, phoneColumn,addressColumn,emailColumn);

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            Contact newContact = new Contact("", "", "","");
            contactList.add(newContact);
        });
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> {
            Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
            if (selectedContact != null) {
                contactList.remove(selectedContact);
            }
        });

        VBox vbox = new VBox(tableView, new HBox(addButton, deleteButton));
        vbox.setSpacing(10);

        tableView.setItems(contactList);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Contact Table");
        primaryStage.show();
    }
}
