package com.example.project_is413;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ContactController extends Application {
    private ContactModel contactModel;
    private ContactView contactView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
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
}
