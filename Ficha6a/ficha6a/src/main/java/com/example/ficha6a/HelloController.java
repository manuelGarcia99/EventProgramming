package com.example.ficha6a;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.TouchPoint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    public TextField numero1;
    @FXML
    public Label operador;
    @FXML
    public TextField numero2;
    @FXML
    public Label igual;
    @FXML
    public TextField resultado;
    @FXML
    public Button buttonNext;
    @FXML
    public Label score;
    @FXML
    public Character  ch;
    @FXML
    public void GetScore(Integer change){
        score.setText(change.toString() + " points");
    }
    @FXML
    public void onclick(){

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("janelaB.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 344);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);

        stage.show();
        ControllerJanelaB controllerJanelaB = fxmlLoader.getController();
        controllerJanelaB.Getresultado(Integer.parseInt(resultado.getText()));
        controllerJanelaB.GetNumeros(Integer.parseInt(numero1.getText()),Integer.parseInt(numero2.getText()));
        controllerJanelaB.GetOperador(ch);
        String aux1 =score.getText();
        String [] arraux = aux1.split(" ");
        controllerJanelaB.GetPoints(Integer.parseInt(arraux[0]));
        Stage oldStage = (Stage) numero1.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        igual.setText("=");
        resultado.setText(Integer.toString(((int)Math.round(Math.random() * 99) )  +1));
        numero1.setText(Integer.toString(((int)Math.round(Math.random()* 99) )  +1));
        numero2.setText(Integer.toString(((int)Math.round(Math.random() * 99) )  +1));
        int escolha = ((int)Math.round(Math.random()* 4))  +1;
        String aleatoria = "";
        switch (escolha) {
            case 1 : aleatoria = "+"; break;
            case 2 : aleatoria = "-"; break;
            case 3 : aleatoria = "x"; break;
            case 4 : aleatoria = "/"; break;
            default :
                System.out.println("Houve um erro na randomização!");
                return;
        }

        ch = aleatoria.charAt(0);

    }


}