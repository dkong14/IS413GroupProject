package com.example.is413groupproject;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.getSaveButton().setOnAction(event -> {
            String name = view.getNameTextField().getText();
            String phone = view.getPhoneTextField().getText();
            String address = view.getAddressTextField().getText();
            String email = view.getEmailTextField().getText();
            String secondaryEmail = view.getSecondaryEmailTextField().getText();

            DataEntry dataEntry = new DataEntry(name, phone, address, email, secondaryEmail);
            model.saveDataToFile(dataEntry);
            model.getDataEntries().add(dataEntry);

            view.getNameTextField().clear();
            view.getPhoneTextField().clear();
            view.getAddressTextField().clear();
            view.getEmailTextField().clear();
            view.getSecondaryEmailTextField().clear();
        });

        view.getTableView().setItems(model.getDataEntries());

        view.getEditButton().setOnAction(event -> {
            DataEntry selectedEntry = view.getTableView().getSelectionModel().getSelectedItem();
            if (selectedEntry != null) {
                String newName = view.getNameTextField().getText();
                String newPhone = view.getPhoneTextField().getText();
                String newAddress = view.getAddressTextField().getText();
                String newEmail = view.getEmailTextField().getText();
                String newSecondaryEmail = view.getSecondaryEmailTextField().getText();

                DataEntry newEntry = new DataEntry(newName, newPhone, newAddress, newEmail, newSecondaryEmail);
                model.updateDataEntry(selectedEntry, newEntry);

                view.getNameTextField().clear();
                view.getPhoneTextField().clear();
                view.getAddressTextField().clear();
                view.getEmailTextField().clear();
                view.getSecondaryEmailTextField().clear();
            }
        });

        view.getDeleteButton().setOnAction(event -> {
            DataEntry selectedEntry = view.getTableView().getSelectionModel().getSelectedItem();
            if (selectedEntry != null) {
                model.deleteDataEntry(selectedEntry);

                view.getNameTextField().clear();
                view.getPhoneTextField().clear();
                view.getAddressTextField().clear();
                view.getEmailTextField().clear();
                view.getSecondaryEmailTextField().clear();
            }
        });

        view.getTableView().setOnMouseClicked(event -> {
            DataEntry selectedEntry = view.getTableView().getSelectionModel().getSelectedItem();
            if (selectedEntry != null) {
                view.getNameTextField().setText(selectedEntry.getName());
                view.getPhoneTextField().setText(selectedEntry.getPhoneNumber());
                view.getAddressTextField().setText(selectedEntry.getAddress());
                view.getEmailTextField().setText(selectedEntry.getEmail());
                view.getSecondaryEmailTextField().setText(selectedEntry.getSecondaryEmail());
            }
        });
    }
}