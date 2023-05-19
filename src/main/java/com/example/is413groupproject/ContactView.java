package com.example.is413groupproject;
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

public class ContactView {
    private TableView<Contact> tableView;
    private Button addButton;
    private Button deleteButton;

    public ContactView() {
        tableView = new TableView<>();
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
        TableColumn<Contact, String> primaryEmailColumn = new TableColumn<>("Primary Email");
        primaryEmailColumn.setCellValueFactory(new PropertyValueFactory<>("primaryEmail"));
        primaryEmailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        primaryEmailColumn.setOnEditCommit(event -> {
            Contact contact = event.getTableView().getItems().get(event.getTablePosition().getRow());
            contact.setPrimaryEmail(event.getNewValue());
        });

        TableColumn<Contact, String> secondaryEmailColumn = new TableColumn<>("Secondary Email");
        secondaryEmailColumn.setCellValueFactory(new PropertyValueFactory<>("secondaryEmail"));
        secondaryEmailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        secondaryEmailColumn.setOnEditCommit(event -> {
            Contact contact = event.getTableView().getItems().get(event.getTablePosition().getRow());
            contact.setSecondaryEmail(event.getNewValue());
        });

        tableView.getColumns().addAll(nameColumn, phoneColumn,addressColumn,primaryEmailColumn, secondaryEmailColumn);

        addButton = new Button("Add");
        deleteButton = new Button("Delete");

        VBox vbox = new VBox(tableView, new HBox(addButton, deleteButton));
        vbox.setSpacing(10);

        Scene scene = new Scene(vbox, 400, 300);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Contact Table");
        primaryStage.show();
    }

    public TableView<Contact> getTableView() {
        return tableView;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setContactList(ObservableList<Contact> contactList) {
        tableView.setItems(contactList);
    }
}


