package com.example.ficha5b;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Spinner<Integer> spinner;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Button button;

    @FXML
    private ToggleButton square;

    @FXML
    private ToggleButton circle;

    @FXML
    private ToggleButton triangle;

    @FXML
    private ToggleGroup formas;



    @FXML
    private Pane pane ;



    @FXML
    private void limpaTela(){
        pane.getChildren().clear();

    }

    @FXML
    private void createForma(double x, double y)
    {

        if(formas.getSelectedToggle().equals(triangle))
        {
            if(y+5*spinner.getValue() > 340){return;}
            Polygon novaForma =  new Polygon(x,y-spinner.getValue()*10,x+5*Math.sqrt(3)*spinner.getValue(),y+5*spinner.getValue(),x-5*Math.sqrt(3)*spinner.getValue(),y+ 5 *spinner.getValue()) ;///faltam os dados
            novaForma.setFill(colorPicker.getValue());
            pane.getChildren().add(novaForma);



        } else if (formas.getSelectedToggle().equals(square)) {
            if(y+5*spinner.getValue()> 340){
                return;
            }
            Rectangle novaForma = new Rectangle(spinner.getValue()*10,spinner.getValue()*10,colorPicker.getValue());
            pane.getChildren().add(novaForma);
            novaForma.setX(x-spinner.getValue()*5);
            novaForma.setY(y-spinner.getValue()*5);
        }
        else{
            if(y+spinner.getValue() *10 > 340){
                return;
            }

            Circle novaForma = new Circle(spinner.getValue()* 10,colorPicker.getValue());
            pane.getChildren().add(novaForma);
            novaForma.setLayoutX(x);
            novaForma.setLayoutY(y);

        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        SpinnerValueFactory<Integer> factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        spinner.setValueFactory(factory);



    }

    @FXML
    private void aoClicarNaRegion(){
        pane.setOnMouseReleased(event -> createForma(event.getX(),event.getY()));
    }



    ///Perceber como se acede ao grupo de toggle buttonsV
    ///Regista o ultimo clique do rato as coordenadasV
    ///Fazer uma função que cria ,3 vezes ,a forma respetiva segundo o input que outra função devolve e esta é a função que ve qual tb está premido
    ///Fazer uma função que altere o collorpicker V
    ///fazer uma função que altere o spinner v
    ///Fazer a função do clear
}