package com.example.ficha3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    /*@FXML
    private Label welcomeText;*/
    @FXML
    public TextArea area ;
    @FXML
    public TextField aProcurar;
    @FXML
    public TextField resultado;
    @FXML
    public Button butao;
    @FXML
    public CheckBox check;
    @FXML
    public int howManySubStrings(String grande , String pequena, boolean checked){
        int inicioDaPalavra=0, contador=0, i;
        for( i = 0 ;i < grande.length(); i++){
            if(grande.charAt(i) == ' ' || grande.charAt(i) == '\n')
            {
                if((!checked) ? pequena.equals(grande.substring(inicioDaPalavra, i)) : pequena.toLowerCase().equals(grande.toLowerCase().substring(inicioDaPalavra,i))){
                    contador++;
                }
                inicioDaPalavra= i+1;
            }
        }
        if((!checked) ? pequena.equals(grande.substring(inicioDaPalavra, i)) : pequena.toLowerCase().equals(grande.toLowerCase().substring(inicioDaPalavra,i))){
            contador++;
        }

        return contador;

    }

    @FXML
    protected void onHelloButtonClick() {
        //welcomeText.setText("Welcome to JavaFX Application!");
        resultado.setText(Integer.toString(howManySubStrings(area.getText(),aProcurar.getText(),check.isSelected())));


    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        area.setText("O João Pestana saiu e tu foste para a cama.\n" +
                "JJJJoão Pestana\n");
    }
}