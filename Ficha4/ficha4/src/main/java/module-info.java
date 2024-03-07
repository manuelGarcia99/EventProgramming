module com.example.ficha4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires Registadora;

    opens com.example.ficha4 to javafx.fxml;
    exports com.example.ficha4;
}