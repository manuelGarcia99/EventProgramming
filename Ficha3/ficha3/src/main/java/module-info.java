module com.example.ficha3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.ficha3 to javafx.fxml;
    exports com.example.ficha3;
}