package com.example.aron;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField numA;
    @FXML
    private TextField numB;
    @FXML
    private TextField numC;
    @FXML
    private TextField area;
    @FXML
    private Button calc;
    /*@FXML
    private ImageView imageView;
    @FXML
    private Image image ;
    @FXML
    private Image pic;*/

    @FXML
    protected void onHelloButtonClick() throws IOException {
        //ImageView myImageView;
        //myImageView = new ImageView(getClass().getResourceAsStream(""))

        double a = Double.parseDouble(numA.getText());
        double b = Double.parseDouble(numB.getText());
        double c = Double.parseDouble(numC.getText());
        double s = (a+b+c) /2 ;
        double res= Math.sqrt(s*(s-a)*(s-b)*(s-c));
        area.setText(Double.toString(res));
    }

}
