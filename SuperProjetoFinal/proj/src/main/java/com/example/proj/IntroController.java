package com.example.proj;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class IntroController {
    @FXML
    Button button;

    public void onclick(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("jogo.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1200, 700);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("PosicionarA!");
        stage.setScene(scene);

        stage.show();

        Stage oldStage = (Stage) button.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }
}
