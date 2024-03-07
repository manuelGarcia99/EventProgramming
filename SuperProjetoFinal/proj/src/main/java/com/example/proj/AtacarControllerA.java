package com.example.proj;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class AtacarControllerA implements Initializable {

    public ArrayList<Barco> listaDeBarcosA;
    public ArrayList<Barco> listaDeBarcosB;
    public ArrayList<Point> ataquesSofridosA;
    public ArrayList<Point> ataquesSofridosB;
    @FXML
    Button voltar;
    @FXML
    GridPane mar;
    @FXML
    Label azul = new Label();
    @FXML
    Label branco = new Label();
    @FXML
    Label vermelho = new Label();
    @FXML
    Label rosa = new Label();
    @FXML
    Label[][] matrizDeLabels = new Label [14][14];


    @FXML
    public void GetAtaquesSofridosA(ArrayList<Point> ataquesSofridosA) {
        this.ataquesSofridosA =  ataquesSofridosA;
    }
    @FXML
    public void GetAtaquesSofridosB(ArrayList<Point> ataquesSofridosB) {
        this.ataquesSofridosB =  ataquesSofridosB;
        for(Point duplo : ataquesSofridosB){
            Label label = new Label("");
            label.setStyle(branco.getStyle());
            label.setMaxWidth(Double.MAX_VALUE -10);
            label.setMaxHeight(Double.MAX_VALUE);
            matrizDeLabels[ duplo.getX()][ duplo.getY()].setStyle(branco.getStyle());
        }
    }
    @FXML
    public void GetListaDeBarcosA(ArrayList<Barco> listaDeBarcosA){
        this.listaDeBarcosA =  listaDeBarcosA;
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
                    if(!vivo)
                    {
                        Label label = new Label("");
                        label.setStyle(vermelho.getStyle());
                        label.setMaxWidth(Double.MAX_VALUE -10);
                        label.setMaxHeight(Double.MAX_VALUE);
                        matrizDeLabels[coordenada.getX()][coordenada.getY()].setStyle(label.getStyle());
                    }

                }
            }
            else{
                Enumeration<Point> keys = S.listaDeDanos.keys();
                while (keys.hasMoreElements()){
                    Point coordenada = keys.nextElement();
                    Label label = new Label(S.ID.toString());
                    label.setStyle(rosa.getStyle());
                    label.setMaxWidth(Double.MAX_VALUE -10);
                    label.setMaxHeight(Double.MAX_VALUE);
                    matrizDeLabels[coordenada.getX()][coordenada.getY()].setText(label.getText());
                    matrizDeLabels[coordenada.getX()][coordenada.getY()].setStyle(label.getStyle());
                }
            }
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Ataque A");
        listaDeBarcosA = new ArrayList<>();
        listaDeBarcosB = new ArrayList<>();
        ataquesSofridosA= new ArrayList<>();
        ataquesSofridosB = new ArrayList<>();
        rosa.setStyle("-fx-border-color: black ; -fx-background-color: pink;-fx-text-fill: black;-fx-alignment: center;");
        azul.setStyle("-fx-border-color: black ; -fx-background-color: blue;");
        vermelho.setStyle("-fx-border-color: black ; -fx-background-color: red;");
        branco.setStyle("-fx-border-color: black ; -fx-background-color: white;");
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                Label label = new Label("");
                label.setStyle(azul.getStyle());
                label.setMaxWidth(Double.MAX_VALUE -10);
                label.setMaxHeight(Double.MAX_VALUE);
                label.onMouseReleasedProperty().set(mouseEvent -> {
                   if(label.getStyle().equals(azul.getStyle())){
                       Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                       alert.setTitle("Confirmação");
                       alert.setHeaderText("É mesmo esta?");

                       ButtonType okButton = new ButtonType("OK");
                       ButtonType cancelButton = new ButtonType("Cancel");

                       alert.getButtonTypes().setAll(okButton, cancelButton);
                       alert.showAndWait().ifPresent(buttonType -> {
                           if (buttonType == okButton) {
                               System.out.println("Debug 1 o ok button funcionou ataque de A a B");
                               ///Fazer ataque
                               for(int r = 0; r<= 13 ; r++){
                                   for(int c =0 ; c<= 13;c++){
                                       if (matrizDeLabels[r][c].equals(label)) {
                                           System.out.println("Na matriz havia o label Ataque de A a B X : " + r +" Y :" +c);
                                           ataquesSofridosB.add(new Point(r,c));

                                           for(Barco S : listaDeBarcosB){
                                               Enumeration<Point> keys = S.listaDeDanos.keys();
                                               while (keys.hasMoreElements()){
                                                   Point coordenada = keys.nextElement();
                                                   if(coordenada.getX() == r && coordenada.getY() == c){
                                                       System.out.println("Atingimos!!!!! ataque de A a B X: "+ r +" Y: " + c);
                                                       S.listaDeDanos.put(coordenada, false);
                                                       S.numDeCasasVivas--;
                                                       S.numDeCasasDestruidas++;
                                                       boolean victory = true;
                                                       for(Barco N : listaDeBarcosB){
                                                           if(N.numDeCasasVivas != 0){
                                                               victory= false;
                                                               break;
                                                           }
                                                       }
                                                       if(victory)///terminar jogo
                                                       {
                                                           FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("vitoria.fxml"));
                                                           Scene scene = null;
                                                           try {
                                                               scene = new Scene(fxmlLoader.load(), 600, 400);
                                                           } catch (IOException e) {
                                                               throw new RuntimeException(e);
                                                           }
                                                           Stage stage = new Stage();
                                                           stage.setTitle("Vitoria A!");
                                                           stage.setScene(scene);

                                                           stage.show();
                                                           VitoriaA controllerJanelaA = fxmlLoader.getController();

                                                           Stage oldStage = (Stage) mar.getScene().getWindow();
                                                           oldStage.close();
                                                           oldStage = null;
                                                       }
                                                       break;
                                                   }
                                               }

                                               }


                                           }
                                       }

                                   }
                               //Passa para o batalha B
                               FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tabuleiroB.fxml"));
                               Scene scene = null;
                               try {
                                   scene = new Scene(fxmlLoader.load(), 600, 600);
                               } catch (IOException e) {
                                   throw new RuntimeException(e);
                               }
                               Stage stage = new Stage();
                               stage.setTitle("Tabuleiro B Turno B!");
                               stage.setScene(scene);

                               stage.show();
                               BatalhaJogadorB controllerJanelaB = fxmlLoader.getController();
                               controllerJanelaB.GetAtaquesSofridosA(ataquesSofridosA);
                               controllerJanelaB.GetAtaquesSofridosB(ataquesSofridosB);
                               controllerJanelaB.GetListaDeBarcosA(listaDeBarcosA);
                               controllerJanelaB.GetListaDeBarcosB(listaDeBarcosB);
                               Stage oldStage = (Stage) mar.getScene().getWindow();
                               oldStage.close();
                               oldStage = null;
                           }  ///Nada
                       });
                   }

                });
                matrizDeLabels[i][j] = label;
                mar.add(label,j,i);
            }
        }

    }

    @FXML
    public void onClickVoltar(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tabuleiro.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Tabuleiro A Turno A!");
        stage.setScene(scene);

        stage.show();
        BatalhaJogadorA controllerJanelaA = fxmlLoader.getController();
        controllerJanelaA.GetAtaquesSofridosA(ataquesSofridosA);
        controllerJanelaA.GetAtaquesSofridosB(ataquesSofridosB);
        controllerJanelaA.GetListaDeBarcosA(listaDeBarcosA);
        controllerJanelaA.GetListaDeBarcosB(listaDeBarcosB);

        Stage oldStage = (Stage) mar.getScene().getWindow();
        oldStage.close();
        oldStage = null;
    }
}
