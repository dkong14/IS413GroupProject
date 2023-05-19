package com.example.is413groupproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Contact extends Application {

    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        Scene scene = new Scene(view.getLayout());
        // adds CSS styling
        //String css = this.getClass().getResource("styleSheet1.css").toExternalForm();
        //scene.getStylesheets().add(css);
        primaryStage.setTitle("Save to File Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

