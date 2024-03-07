package com.example.ficha4;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;

import pt.ubi.ihc.Registadora;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable  {

    Integer Last = -1;
    Registadora calc = new Registadora();
    String Number = "";

    @FXML
    public TextArea text ;
    @FXML
    public Label resultadoAtual;
    @FXML
    public SplitPane teclado ;
    @FXML
    List<? extends Node> allButtons ;


    @FXML
    public void onResultClick()
    {
        if(text.getText().equals("") || Last != 5){
            return;
        }
        calc.regista(Double.parseDouble(Number));
        resultadoAtual.setText(calc.toString());
        Last = 1;
    }

    @FXML
    public void onApagarClick()
    {
        if(text.getText().equals("")){
            return;
        }
        Number = "";
        text.setText("");
        calc = new Registadora(0.0);
        Last =2;
    }
    @FXML
    public void onDotClick(){
        if(text.getText().equals("") || Last != 5 || Number.indexOf('.') != -1){
            return;
        }

        Number = Number + ".";
        String buffer = text.getText();
        text.setText(buffer + ".");
        Last = 3;
    }
    @FXML
    public void onOperatorClick(String operador)
    {
        if(text.getText().equals("") || Number.equals("")){
            return;
        }
        if(Last != 1) {
            calc.regista(Double.parseDouble(Number));
        }
        String buffer = text.getText();
        text.setText(buffer + " " + operador + '\n');
        Number = "";
        calc.defineOperador(operador.charAt(0));
        Last = 4;
    }
    @FXML
    public void onNumberClick(String algarismo){

        Number = Number + algarismo;
        String buffer = text.getText();
        text.setText(buffer + algarismo );


        Last = 5;
    }
    public void buttonClickHandler(Button button) {



        // Now you can use the clickedButton object in any way you like
        if (button.getText().equals("C")) {
            onApagarClick();
        } else if (button.getText().equals("Resultado")) {
            onResultClick();
        } else if (button.getText().equals(".")) {
            onDotClick();
        } else if (button.getText().equals("+") ||
                button.getText().equals("-") ||
                button.getText().equals("/") ||
                button.getText().equals("x")) {
            onOperatorClick(button.getText());
        } else {
            onNumberClick(button.getText());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        allButtons = new ArrayList<>(teclado.lookupAll(".button"));


    }
    @FXML
    public void onButtonClick() {

        allButtons = new ArrayList<>(teclado.lookupAll(".button"));

        for (Node node : allButtons) {
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setOnAction(event -> buttonClickHandler(button));
            }
        }


    }
    }






