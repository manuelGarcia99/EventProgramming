module com.example.aron {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.example.aron to javafx.fxml;
    exports com.example.aron;
}