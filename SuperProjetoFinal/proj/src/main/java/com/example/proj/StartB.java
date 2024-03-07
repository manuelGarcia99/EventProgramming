package com.example.proj;///Usa so eventos so eventos nada de loops portanto cada coisa é um evento tens  que lidar

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.ResourceBundle;

public class StartB  implements Initializable {

    @FXML
    GridPane costa;
    @FXML
    GridPane mar;
    @FXML
    Label[][] matrizDeLabels = new Label [14][14];


    @FXML
    ArrayList<ImageView> imagens = new ArrayList<>(6);
    //@FXML
    //ArrayList<Button> butoes = new ArrayList<>(2);//terceiro butão para remover barco
    @FXML
    ArrayList<Label> laranjas = new ArrayList<>(6);
    @FXML
    Button roda;
    @FXML
    Button confirma;
    @FXML
    List<ClickableNode> clickables= new ArrayList<>();


    @FXML
    Label verdeEscuro = new Label();
    @FXML
    Label castanho = new Label();
    @FXML
    Label azulEscuro = new Label();
    @FXML
    Label verde = new Label();
    @FXML
    Label rosa = new Label();
    @FXML
    Label laranja = new Label();
    Boolean estouAEscolherUmNavio ;
    Integer larguraDeBarcoAInserir = 0;
    Integer alturaDeBarcoAinserir=0;
    Boolean estouAPorUmNavio;
    Boolean estouAEstenderOBarco;
    Character orientacao ;
    Hashtable verificaSeADirecaoEViavel = new Hashtable<Character,Boolean>(4);
    boolean passouPelaRodagem ;

    Character barcoEscolhido ;

    ArrayList<Barco> listaDeBarcos;
    ArrayList<Barco> listaDeBarcosDoJogadorA;
    ArrayList<Character> CaracteresjaPostos;

    @FXML
    public void GetListaDeBarcosA(ArrayList<Barco> listaDoInimigo){
        listaDeBarcosDoJogadorA = listaDoInimigo;

    }


    public boolean oBarcoCabe(int x , int y){
        Boolean haBarcoEmBaixo= false;
        Boolean haBarcoEmCima = false;
        Boolean haBarcoAdireita = false;
        Boolean haBarcoAEsquerda = false;
        int contador=0;
        while(contador < larguraDeBarcoAInserir){
            if(x+ contador > 13){

            }
            else{
                if(matrizDeLabels[x+contador][y].getStyle().equals(verdeEscuro.getStyle())){
                    haBarcoEmBaixo = true;
                }
            }
            if(x- contador < 0){

            }
            else{
                if(matrizDeLabels[x-contador][y].getStyle().equals(verdeEscuro.getStyle())){
                    haBarcoEmCima = true;
                }
            }
            if(y+ contador > 13){

            }
            else{
                if(matrizDeLabels[x][y+ contador].getStyle().equals(verdeEscuro.getStyle())){
                    haBarcoAdireita = true;
                }
            }
            if(y- contador < 0){

            }
            else{
                if(matrizDeLabels[x][y- contador].getStyle().equals(verdeEscuro.getStyle())){
                    haBarcoAEsquerda = true;
                }
            }
            if(((x + contador > 13  ) || haBarcoEmBaixo) && ((x- contador < 0) || haBarcoEmCima) && ((y+ contador > 13 ) || haBarcoAdireita ) && ((y-contador <0) || haBarcoAEsquerda ) ){
                return false;
            }
            contador++;
        }
        return true;
    }

    public Hashtable rodarBarcoBools(int x, int y) {
        boolean haBarcoEmBaixoOuNaoCabe = false;
        boolean haBarcoEmCimaOuNaoCabe = false;
        boolean haBarcoAdireitaOuNaoCabe = false;
        boolean haBarcoAEsquerdaOuNaoCabe = false;
        orientacao = 'd';
        int contador = 0;
        while (contador < larguraDeBarcoAInserir) {
            if (x + contador > 13) {
                haBarcoEmBaixoOuNaoCabe = true;
            } else {
                if (matrizDeLabels[x + contador][y].getStyle().equals(verdeEscuro.getStyle())) {
                    haBarcoEmBaixoOuNaoCabe = true;
                }
            }
            if (x - contador < 0) {
                haBarcoEmCimaOuNaoCabe = true;
            } else {
                if (matrizDeLabels[x - contador][y].getStyle().equals(verdeEscuro.getStyle())) {
                    haBarcoEmCimaOuNaoCabe = true;
                }
            }
            if (y + contador > 13) {
                haBarcoAdireitaOuNaoCabe = true;
            } else {
                if (matrizDeLabels[x][y + contador].getStyle().equals(verdeEscuro.getStyle())) {
                    haBarcoAdireitaOuNaoCabe = true;
                }
            }
            if (y - contador < 0) {
                haBarcoAEsquerdaOuNaoCabe = true;
            } else {
                if (matrizDeLabels[x][y - contador].getStyle().equals(verdeEscuro.getStyle())) {
                    haBarcoAEsquerdaOuNaoCabe = true;
                }
            }
            contador++;
        }

        verificaSeADirecaoEViavel.put('d',!haBarcoAdireitaOuNaoCabe);
        verificaSeADirecaoEViavel.put('b',!haBarcoEmBaixoOuNaoCabe);
        verificaSeADirecaoEViavel.put('e',!haBarcoAEsquerdaOuNaoCabe);
        verificaSeADirecaoEViavel.put('c',!haBarcoEmCimaOuNaoCabe);

        return verificaSeADirecaoEViavel;

    }

    public void deitaBarco( Label original ){



        for(int i = 0; i<= 13 ; i++){
            for(int j =0 ; j<= 13;j++){
                if (matrizDeLabels[i][j].equals(original)) {///so estamos a pensar de barcos de altura 1
                    if(!oBarcoCabe(i,j)) return;
                    System.out.println("Chegou1");
                    matrizDeLabels[i][j].setStyle(castanho.getStyle());
                    estouAPorUmNavio= false;
                    estouAEstenderOBarco = true;
                    rodarBarcoBools(i,j);
                    return;

                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orientacao= 'd';
        listaDeBarcosDoJogadorA= new ArrayList<>();
        listaDeBarcos = new ArrayList<>();
        CaracteresjaPostos = new ArrayList<>();
        laranja.setStyle("-fx-background-color: orange ; -fx-border-color: darkblue;");
        verdeEscuro.setStyle("-fx-border-color: white ; -fx-background-color : darkgreen;");
        castanho.setStyle("-fx-border-color: white ; -fx-background-color : brown;");
        azulEscuro.setStyle("-fx-border-color: white ; -fx-background-color: darkblue;");
        verde.setStyle("-fx-border-color: white ; -fx-background-color : green;");
        rosa.setStyle("-fx-border-color: white ; -fx-background-color : pink;");
        for(int x= 0  ; x<= 13; x++){
            for(int y= 0  ; y<= 13; y++){
                Label label = new Label("");
                label.setStyle(azulEscuro.getStyle());
                label.setMaxWidth(Double.MAX_VALUE -10);
                label.setMaxHeight(Double.MAX_VALUE);
                label.onMouseEnteredProperty().set((mouseEvent -> {if(larguraDeBarcoAInserir > 0 && label.getStyle().equals(azulEscuro.getStyle()) )label.setStyle(verde.getStyle());}));
                label.onMouseExitedProperty().set((mouseEvent -> {if(label.getStyle().equals(verde.getStyle())) label.setStyle(azulEscuro.getStyle());}));
                label.onMouseReleasedProperty().set((mouseEvent -> {if(estouAPorUmNavio && !label.getStyle().equals(verdeEscuro.getStyle())) deitaBarco(label);}));
                matrizDeLabels[x][y] = label;
                mar.add(label,y,x);
            }}
        costa.setStyle("-fx-background-color: transparent;");
        URL currentDirectory = getClass().getResource("ship0.png");
        Image barco1 = new Image(currentDirectory.toString());
        ImageView navio1 = new ImageView(barco1);
        costa.add(navio1 , 0,1);
        imagens.add(navio1);
        Label ship1 = new Label("");
        ship1.setStyle(laranja.getStyle());
        ship1.setMaxWidth(Double.MAX_VALUE-10);
        ship1.setMaxHeight(Double.MAX_VALUE);
        ship1.onMouseReleasedProperty().set(mouseEvent -> {
            if(estouAEscolherUmNavio) {
                larguraDeBarcoAInserir = 5;
                alturaDeBarcoAinserir = 2;
                estouAEscolherUmNavio = false;
                estouAPorUmNavio = true;
            }});
        costa.add(ship1,1,1);
        //laranjas.add(ship1);
        URL currentDirectory2 = getClass().getResource("ship1.png");
        Image barco2 = new Image(currentDirectory2.toString());
        ImageView navio2 = new ImageView(barco2);
        costa.add(navio2 , 0,2);
        //imagens.add(navio2);
        Label ship2 = new Label("");
        ship2.setStyle(laranja.getStyle());
        ship2.setMaxWidth(Double.MAX_VALUE-10);
        ship2.setMaxHeight(Double.MAX_VALUE);
        ship2.onMouseReleasedProperty().set(mouseEvent -> {if(estouAEscolherUmNavio && !CaracteresjaPostos.contains('B')){
            larguraDeBarcoAInserir = 5;
            alturaDeBarcoAinserir=1;
            estouAEscolherUmNavio = false;
            estouAPorUmNavio=true;
            barcoEscolhido = 'B';
        }});
        costa.add(ship2,1,2);
        //laranjas.add(ship2);
        URL currentDirectory3 = getClass().getResource("ship2.png");
        Image barco3 = new Image(currentDirectory3.toString());
        ImageView navio3 = new ImageView(barco3);
        costa.add(navio3 , 0,3);
        Label ship3 = new Label("");
        ship3.setStyle(laranja.getStyle());
        ship3.setMaxWidth(Double.MAX_VALUE-10);
        ship3.setMaxHeight(Double.MAX_VALUE);
        ship3.onMouseReleasedProperty().set(mouseEvent -> {
            if(estouAEscolherUmNavio && !CaracteresjaPostos.contains('A')){
                larguraDeBarcoAInserir = 4;
                alturaDeBarcoAinserir = 1;
                estouAEscolherUmNavio = false;
                estouAPorUmNavio=true;
                barcoEscolhido= 'A';
            }});
        costa.add(ship3,1,3);
        //laranjas.add(ship3);
        URL currentDirectory4 = getClass().getResource("ship3.png");
        Image barco4 = new Image(currentDirectory4.toString());
        ImageView navio4 = new ImageView(barco4);
        costa.add(navio4 , 0,4);
        Label ship4 = new Label("");
        ship4.setStyle(laranja.getStyle());
        ship4.setMaxWidth(Double.MAX_VALUE-10);
        ship4.setMaxHeight(Double.MAX_VALUE);
        ship4.onMouseReleasedProperty().set(mouseEvent -> {
            if(estouAEscolherUmNavio && !CaracteresjaPostos.contains('T') ){
                larguraDeBarcoAInserir = 3;
                alturaDeBarcoAinserir = 1;
                estouAEscolherUmNavio = false;
                estouAPorUmNavio=true;
                barcoEscolhido = 'T';
            }});
        costa.add(ship4,1,4);
        //laranjas.add(ship4);
        URL currentDirectory5 = getClass().getResource("ship4.png");
        Image barco5 = new Image(currentDirectory5.toString());
        ImageView navio5 = new ImageView(barco5);
        costa.add(navio5 , 0,5);
        Label ship5 = new Label("");
        ship5.setStyle(laranja.getStyle());
        ship5.setMaxWidth(Double.MAX_VALUE-10);
        ship5.setMaxHeight(Double.MAX_VALUE);
        ship5.onMouseReleasedProperty().set(mouseEvent -> {
            if(estouAEscolherUmNavio && !CaracteresjaPostos.contains('S')){
                larguraDeBarcoAInserir = 3;
                alturaDeBarcoAinserir = 1;
                estouAEscolherUmNavio = false;
                estouAPorUmNavio=true;
                barcoEscolhido = 'S';
            }});
        costa.add(ship5,1,5);
        //laranjas.add(ship5);
        URL currentDirectory6 = getClass().getResource("ship5.png");
        Image barco6 = new Image(currentDirectory6.toString());
        ImageView navio6 = new ImageView(barco6);
        costa.add(navio6 , 0,6);
        Label ship6 = new Label("");
        ship6.setStyle(laranja.getStyle());
        ship6.setMaxWidth(Double.MAX_VALUE-10);
        ship6.setMaxHeight(Double.MAX_VALUE);
        ship6.onMouseReleasedProperty().set(mouseEvent -> {
            if(estouAEscolherUmNavio &&  !CaracteresjaPostos.contains('L')){
                larguraDeBarcoAInserir = 2;
                alturaDeBarcoAinserir = 1;
                estouAEscolherUmNavio = false;
                estouAPorUmNavio=true;
                barcoEscolhido= 'L';
            }});
        costa.add(ship6,1,6);
        //laranjas.add(ship6);
        estouAEscolherUmNavio = true;
        estouAPorUmNavio =false;
        estouAEstenderOBarco = false;
        passouPelaRodagem = false;
    }

    void rodaSemClique(){
        switch (orientacao) {
            case 'd' -> orientacao = 'b';
            case 'b' -> orientacao = 'e';
            case 'e' -> orientacao = 'c';
            case 'c' -> orientacao = 'd';
            default -> System.out.println("An error occurred");
        }
    }
    @FXML
    void onclickRoda(){
        System.out.println("Roda");
        if(estouAEstenderOBarco){
            for (int i = 0; i < 14; i++) {
                for (int j = 0; j < 14; j++) {
                    if(! matrizDeLabels[i][j].getStyle().equals(castanho.getStyle()) && ! matrizDeLabels[i][j].getStyle().equals(verdeEscuro.getStyle()))
                        matrizDeLabels[i][j].setStyle(azulEscuro.getStyle());
                }
            }
            for (int i = 0; i < 14; i++) {
                for (int j = 0; j < 14; j++) {
                    if(matrizDeLabels[i][j].getStyle().equals(castanho.getStyle())){
                        while( ! (Boolean) verificaSeADirecaoEViavel.get(orientacao)){

                            rodaSemClique();
                        }
                        int contador = 0;
                        switch(orientacao){
                            case 'd' ->{ while(contador < larguraDeBarcoAInserir){
                                if(contador != 0)matrizDeLabels[i][j+contador].setStyle(rosa.getStyle());
                                contador++;
                            } orientacao= 'b';
                            }
                            case 'b' -> { while(contador < larguraDeBarcoAInserir){
                                if(contador != 0)matrizDeLabels[i+contador][j].setStyle(rosa.getStyle());
                                contador++;
                            } orientacao = 'e';
                            }
                            case 'e' -> { while(contador < larguraDeBarcoAInserir){
                                if(contador != 0)matrizDeLabels[i][j-contador].setStyle(rosa.getStyle());
                                contador++;
                            } orientacao = 'c';
                            }
                            case 'c' -> { while(contador < larguraDeBarcoAInserir){
                                if(contador != 0)matrizDeLabels[i-contador][j].setStyle(rosa.getStyle());
                                contador++;
                            } orientacao = 'd';
                            }
                            default -> System.out.println("An error occurred");
                        }
                        passouPelaRodagem = true;

                    }
                }
            }
        }
        else{
            switch (orientacao) {
                case 'd' -> orientacao = 'b';
                case 'b' -> orientacao = 'e';
                case 'e' -> orientacao = 'c';
                case 'c' -> orientacao = 'd';
                default -> System.out.println("An error occurred");
            }
        }

    }
    @FXML
    void onClickConfirma(){
        if(estouAEstenderOBarco && passouPelaRodagem){
            Barco novoBarco = new Barco(larguraDeBarcoAInserir,barcoEscolhido);
            for (Integer i = 0; i < 14; i++) {
                for (Integer j = 0; j < 14; j++) {
                    if(matrizDeLabels[i][j].getStyle().equals(castanho.getStyle()) || matrizDeLabels[i][j].getStyle().equals(rosa.getStyle())){
                        matrizDeLabels[i][j].setStyle(verdeEscuro.getStyle());
                        novoBarco.listaDeDanos.put(new Point(i,j), true );
                    }
                }
            }
            listaDeBarcos.add(novoBarco);
            CaracteresjaPostos.add(barcoEscolhido);
            if(CaracteresjaPostos.size() == 5){
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
                controllerJanelaA.GetListaDeBarcosA(listaDeBarcosDoJogadorA);
                controllerJanelaA.GetListaDeBarcosB(listaDeBarcos);
                Stage oldStage = (Stage) mar.getScene().getWindow();
                oldStage.close();
                oldStage = null;
            }
            estouAEstenderOBarco = false;
            passouPelaRodagem= false;
            estouAEscolherUmNavio = true;
        }
    }


}