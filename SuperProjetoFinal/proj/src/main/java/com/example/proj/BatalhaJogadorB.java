package com.example.proj;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;



public class BatalhaJogadorB implements Initializable {///Fazer Get dos Barcos Do A e Do B

    public ArrayList<Barco>  listaDeBarcosA;
    public ArrayList<Barco>  listaDeBarcosB;
    public ArrayList<Point> ataquesSofridosA;
    public ArrayList<Point> ataquesSofridosB;
    @FXML
    Label azul = new Label();
    @FXML
    Label vermelho = new Label();
    @FXML
    Label roxo = new Label();
    @FXML
    Label preto = new Label();
    @FXML
    Label azulEscuro = new Label();
    @FXML
    Label[][] matrizDeLabels = new Label [14][14];

    @FXML
    GridPane mar;
    @FXML
    Button butao;

    @FXML
    public void GetAtaquesSofridosA(ArrayList<Point> ataquesSofridosA){
        this.ataquesSofridosA = ataquesSofridosA;
    }

    @FXML
    public void GetAtaquesSofridosB(ArrayList<Point> ataquesSofridosB){
        this.ataquesSofridosB = ataquesSofridosB;
        for(Point duplo : ataquesSofridosB){
            System.out.println("Ataques sofridos até agora no B : " + duplo.getX() + " Y: " + duplo.getY());
            Label label = new Label("");
            label.setStyle(preto.getStyle());
            label.setMaxWidth(Double.MAX_VALUE -10);
            label.setMaxHeight(Double.MAX_VALUE);

            matrizDeLabels[ duplo.getX()][ duplo.getY()].setStyle(preto.getStyle());
        }
    }

    @FXML
    public void GetListaDeBarcosA(ArrayList<Barco> listaDeBarcosA){
        this.listaDeBarcosA = listaDeBarcosA;
    }

    @FXML
    public void GetListaDeBarcosB(ArrayList<Barco> listaDeBarcosB){
        this.listaDeBarcosB =  listaDeBarcosB;
        for(Barco S : listaDeBarcosB){
            if(S.numDeCasasVivas != 0){
                Enumeration<Point> keys = S.listaDeDanos.keys();
                while (keys.hasMoreElements()) {
                    Point coordenada = keys.nextElement();
                    Boolean vivo = S.listaDeDanos.get(coordenada);
                    if(vivo)
                    {
                        System.out.println("Entrou Branco x: " + coordenada.getX() + " y: " + coordenada.getY() + " Tamanho da lista de coordenadas " + S.listaDeDanos.size());
                        Label label = new Label(S.ID.toString());
                        label.setStyle(azul.getStyle());
                        label.setMaxWidth(Double.MAX_VALUE -10);
                        label.setMaxHeight(Double.MAX_VALUE);
                        matrizDeLabels[coordenada.getX()][coordenada.getY()].setText(label.getText());
                        matrizDeLabels[coordenada.getX()][coordenada.getY()].setStyle(label.getStyle());
                    }
                    else{
                        System.out.println("Entrou Vermelho x: " + coordenada.getX() + " y: " + coordenada.getY() + " Tamanho da lista de coordenadas " + S.listaDeDanos.size() );
                        Label label = new Label(S.ID.toString());
                        label.setStyle(vermelho.getStyle());
                        label.setMaxWidth(Double.MAX_VALUE -10);
                        label.setMaxHeight(Double.MAX_VALUE);
                        matrizDeLabels[coordenada.getX()][coordenada.getY()].setText(label.getText());
                        matrizDeLabels[coordenada.getX()][coordenada.getY()].setStyle(label.getStyle());
                    }
                }
            }
            else{
                Enumeration<Point> keys = S.listaDeDanos.keys();
                while (keys.hasMoreElements()){
                    Point coordenada = keys.nextElement();
                    Label label = new Label("");
                    label.setStyle(roxo.getStyle());
                    label.setMaxWidth(Double.MAX_VALUE -10);
                    label.setMaxHeight(Double.MAX_VALUE);
                    matrizDeLabels[coordenada.getX()][coordenada.getY()].setText(label.getText());
                    matrizDeLabels[coordenada.getX()][coordenada.getY()].setStyle(label.getStyle());
                }
            }
        }
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        System.out.println("Batalha B");
        azulEscuro.setStyle("-fx-border-color: black ; -fx-background-color: darkblue;");
        preto.setStyle("-fx-border-color: black ; -fx-background-color: black;");
        azul.setStyle("-fx-border-color: black ; -fx-background-color: white;-fx-text-fill: blue;-fx-alignment: center;");
        vermelho.setStyle("-fx-border-color: black ; -fx-background-color: red;-fx-text-fill: black;-fx-alignment: center;");
        roxo.setStyle("-fx-border-color: black ; -fx-background-color: purple;");

        listaDeBarcosA = new ArrayList<>();
        listaDeBarcosB = new ArrayList<>();
        ataquesSofridosA= new ArrayList<>();
        ataquesSofridosB = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                Label label = new Label("");
                label.setStyle(azulEscuro.getStyle());
                label.setMaxWidth(Double.MAX_VALUE -10);
                label.setMaxHeight(Double.MAX_VALUE);

                matrizDeLabels[i][j] = label;
                mar.add(label,j,i);
            }
        }



    }

    @FXML
    public void onClickAtacar(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AtacarB.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Tabuleiro A Turno B!");
        stage.setScene(scene);

        stage.show();
        AtacarControllerB controllerJanelaB = fxmlLoader.getController();

        controllerJanelaB.GetAtaquesSofridosA(ataquesSofridosA);
        controllerJanelaB.GetAtaquesSofridosB(ataquesSofridosB);
        controllerJanelaB.GetListaDeBarcosA(listaDeBarcosA);
        controllerJanelaB.GetListaDeBarcosB(listaDeBarcosB);

        Stage oldStage = (Stage) mar.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }
}
