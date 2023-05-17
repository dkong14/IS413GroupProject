package com.example.is413groupproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ContactController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}