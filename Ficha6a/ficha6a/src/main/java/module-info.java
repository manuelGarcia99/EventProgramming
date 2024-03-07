module com.example.ficha6a {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ficha6a to javafx.fxml;
    exports com.example.ficha6a;
}