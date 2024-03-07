module com.example.ficha5b {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ficha5b to javafx.fxml;
    exports com.example.ficha5b;
}