module com.example.colorpicker {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.colorpicker to javafx.fxml;
    exports com.example.colorpicker;
}