module com.example.is413groupproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.is413groupproject to javafx.fxml;
    exports com.example.is413groupproject;
}