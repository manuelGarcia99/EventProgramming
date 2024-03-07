module com.example.registoalunoubi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.registoalunoubi to javafx.fxml;
    exports com.example.registoalunoubi;
}