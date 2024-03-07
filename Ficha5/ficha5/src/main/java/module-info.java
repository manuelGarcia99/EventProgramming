module com.example.ficha5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ficha5 to javafx.fxml;
    exports com.example.ficha5;
}