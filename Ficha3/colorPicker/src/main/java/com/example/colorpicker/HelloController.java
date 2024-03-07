package com.example.colorpicker;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.rgb;

public class HelloController implements Initializable  {
   /* @FXML
    private Label welcomeText;*/

    /*@FXML
    protected void onHelloButtonClick() {
        /*welcomeText.setText("Welcome to JavaFX Application!");
    }*/

    @FXML
    private Label rValue;
    @FXML
    private Label gValue;
    @FXML
    private Label bValue;
    @FXML
    private Slider red;
    @FXML
    private Slider green;
    @FXML
    private Slider blue;
    @FXML
    private Pane tela;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double rDouble = red.getValue();
        double gDouble = green.getValue();
        double bDouble = blue.getValue();
        rValue.setText(Double.toString(rDouble));
        gValue.setText(Double.toString(gDouble));
        bValue.setText(Double.toString(bDouble));
    }

    @FXML
    protected void onSliderDrop(){
        Double rDouble = red.getValue();
        Double gDouble = green.getValue();
        Double bDouble = blue.getValue();
        rValue.setText(Double.toString(rDouble));
        gValue.setText(Double.toString(gDouble));
        bValue.setText(Double.toString(bDouble));
        BackgroundFill fill = new BackgroundFill(rgb(rDouble.intValue(),
                gDouble.intValue(),
                bDouble.intValue()),new CornerRadii(0),new Insets(0));
        Background background = new Background(fill);
        tela.setBackground(background);

    }
}