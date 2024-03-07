package com.example.ficha6a;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerJanelaB implements Initializable {

    @FXML
    Label resultado;

    @FXML
    Label numero1;

    @FXML
    Label numero2;

   @FXML
    Label operador;

    @FXML
    Button button;

    @FXML
    Label change;
    @FXML
    Label points;
    @FXML
    public void Getresultado(Integer x){
        resultado.setText(x.toString());
    }
    @FXML
    public void GetNumeros(Integer x, Integer y)
    {
        numero1.setText(x.toString());
        numero2.setText(y.toString());
    }
    @FXML
    public void GetOperador(Character c)
    {
        operador.setText(c.toString());
        Integer operation ;
        switch(operador.getText().charAt(0)){
            case '+' : operation = Integer.parseInt(numero1.getText()) + Integer.parseInt((numero2.getText()));  break;
            case 'x' : operation = Integer.parseInt(numero1.getText()) * Integer.parseInt((numero2.getText()));  break;
            case '-' : operation = Integer.parseInt(numero1.getText()) - Integer.parseInt((numero2.getText()));  break;
            case '/' : operation = Integer.parseInt(numero1.getText()) / Integer.parseInt((numero2.getText()));  break;
            default :
                System.out.println("Error in Bwindow switch"); return;
        }
        change.setText( String.valueOf(operation - Integer.parseInt(resultado.getText())));
    }
    @FXML
    public void GetPoints(Integer score){

        points.setText(score.toString()  );
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    @FXML
    public void onClickAgain(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("janelaA.fxml"));
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
        HelloController controllerJanelaA = fxmlLoader.getController();
        controllerJanelaA.GetScore(Integer.parseInt( change.getText()  ) + Integer.parseInt( points.getText()  ));


        Stage oldStage = (Stage) numero1.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }


}
