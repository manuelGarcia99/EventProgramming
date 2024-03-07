package com.example.registoalunoubi;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField name;
    @FXML
    private TextField num;
    @FXML
    private TextField course;
    @FXML
    private Button regist;
    @FXML
    private Button cancel;

    @FXML
    protected void onHelloButtonClick() {
        System.out.println("Bom dia!");
        String nome_do_aluno = name.getText();
        String numero_do_aluno = num.getText();
        String curso_do_aluno = course.getText();


        System.out.println("O aluno " + nome_do_aluno + "numero: " + numero_do_aluno + " curso: " + curso_do_aluno);
        name.setText("");
        num.setText("");
        course.setText("");
        //O botão registar
        //Deve começar disabled
        //oclique activa
        //o botão cancerlar fecha
    }

}