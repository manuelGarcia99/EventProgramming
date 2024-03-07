package com.example.ficha5;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    Label monday = new Label("Seg");
    @FXML
    Label tuesday = new Label("Ter");
    @FXML
    Label wednesday = new Label("Qua");
    @FXML
    Label thursday = new Label("Qui");
    @FXML
    Label friday = new Label("Sex");
    @FXML
    Label saturday = new Label("Sab");
    @FXML
    Label sunday = new Label("Dom");
    @FXML

    Spinner<Integer> year;
    @FXML
    ComboBox month;
    @FXML
    GridPane gridPane;

    public static int daysInFebruary(int year) {
        if (year % 4 != 0) {
            return 28;
        } else if (year % 100 != 0) {
            return 29;
        } else if (year % 400 != 0) {
            return 28;
        } else {
            return 29;
        }
    }

    public static int monthWithZero(String  mois)
    {
        if(mois.equals("Janeiro")) return 0;
        if(mois.equals("Fevereiro")) return 1;
        if(mois.equals("Março")) return 2;
        if(mois.equals("Abril")) return 3;
        if(mois.equals("Maio")) return 4;
        if(mois.equals("Junho")) return 5;
        if(mois.equals("Julho")) return 6;
        if(mois.equals("Agosto")) return 7;
        if(mois.equals("Setembro")) return 8;
        if(mois.equals("Outubro")) return 9;
        if(mois.equals("Novembro")) return 10;
        if(mois.equals("Dezembro")) return 11;

        return -1;
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        String jan = "Janeiro";
        String fev = "Fevereiro";
        String mar = "Março";
        String abr = "Abril";
        String mai = "Maio";
        String jun = "Junho";
        String jul = "Julho";
        String ago = "Agosto";
        String set = "Setembro";
        String out = "Outubro";
        String nov = "Novembro";
        String dez = "Dezembro";
        month.getItems().addAll(jan,fev,mar,abr,mai,jun,jul,ago,set,out,nov,dez);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1950, 2050);
        year.setValueFactory(valueFactory);
        ArrayList<Label> days = new ArrayList<>(7);

        days.add(monday);

        days.add(tuesday);

        days.add(wednesday);

        days.add(thursday);

        days.add(friday);

        days.add(saturday);

        days.add(sunday);
        for (int i = 0; i < days.size(); i++) {
            Label label = days.get(i);


            if (i < 7) {
                label.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-border-color: black;");
                label.setMaxWidth(Double.MAX_VALUE);
                label.setMaxHeight(Double.MAX_VALUE);
                label.setAlignment(Pos.CENTER);
            }

            gridPane.add(label, i, 0);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, 4);
        calendar.set(Calendar.DATE, 1);


        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int mes = calendar.get(Calendar.MONTH) + 1;
        int numeroDeDiasDoMes  ;
        switch (mes){
            case 1, 3, 5, 7, 8, 10, 12 -> {
                numeroDeDiasDoMes= 31;
                break;
            }
            case 4, 6, 9, 11 -> {
                numeroDeDiasDoMes = 30;
                break;
            }
            case 2 -> {
                numeroDeDiasDoMes = daysInFebruary(calendar.get(Calendar.YEAR));
                break;
            }
            default -> numeroDeDiasDoMes= 0;

        }

        switch(dayOfWeek){
            case 1: dayOfWeek=6; break;//dom
            case 2: dayOfWeek=0; break;//seg
            case 3: dayOfWeek=1 ; break;
            case 4: dayOfWeek=2 ;break;
            case 5: dayOfWeek=3 ;break;
            case 6: dayOfWeek=4 ;break;
            case 7: dayOfWeek=5 ;break;//sab
        }

        for(int i = 1, x =dayOfWeek ,y=1 ;i<= numeroDeDiasDoMes;i++){
            Label label = new Label(String.valueOf(i));
            label.setStyle("  -fx-border-color: black;");
            label.setMaxWidth(Double.MAX_VALUE -10);
            label.setMaxHeight(Double.MAX_VALUE);
            label.setAlignment(Pos.TOP_RIGHT);
            gridPane.add(label,x,y);
            if(++x == 7){
                ++y;
                x=0;
            }
        }
        year.getValueFactory().setValue(2023);
        month.setValue("Maio");
    }

    @FXML
    public void onClickButton(){
        gridPane.getChildren().clear();
        String jan = "Janeiro";
        String fev = "Fevereiro";
        String mar = "Março";
        String abr = "Abril";
        String mai = "Maio";
        String jun = "Junho";
        String jul = "Julho";
        String ago = "Agosto";
        String set = "Setembro";
        String out = "Outubro";
        String nov = "Novembro";
        String dez = "Dezembro";

        ArrayList<Label> days = new ArrayList<>(7);

        days.add(monday);

        days.add(tuesday);

        days.add(wednesday);

        days.add(thursday);

        days.add(friday);

        days.add(saturday);

        days.add(sunday);
        for (int i = 0; i < days.size(); i++) {
            Label label = days.get(i);


            if (i < 7) {
                label.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-border-color: black;");
                label.setMaxWidth(Double.MAX_VALUE);
                label.setMaxHeight(Double.MAX_VALUE);
                label.setAlignment(Pos.CENTER);
            }

            gridPane.add(label, i, 0);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year.getValue());
        calendar.set(Calendar.MONTH, monthWithZero(month.getValue().toString()));
        calendar.set(Calendar.DATE, 1);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int mes = calendar.get(Calendar.MONTH) + 1;
        int numeroDeDiasDoMes  ;
        switch (mes){
            case 1, 3, 5, 7, 8, 10, 12 -> {
                numeroDeDiasDoMes= 31;
                break;
            }
            case 4, 6, 9, 11 -> {
                numeroDeDiasDoMes = 30;
                break;
            }
            case 2 -> {
                numeroDeDiasDoMes = daysInFebruary(calendar.get(Calendar.YEAR));
                break;
            }
            default -> numeroDeDiasDoMes= 0;

        }

        switch(dayOfWeek){
            case 1: dayOfWeek=6; break;//dom
            case 2: dayOfWeek=0; break;//seg
            case 3: dayOfWeek=1 ; break;
            case 4: dayOfWeek=2 ;break;
            case 5: dayOfWeek=3 ;break;
            case 6: dayOfWeek=4 ;break;
            case 7: dayOfWeek=5 ;break;//sab
        }

        for(int i = 1, x =dayOfWeek ,y=1 ;i<= numeroDeDiasDoMes;i++){
            Label label = new Label(String.valueOf(i));
            label.setStyle("  -fx-border-color: black;");
            label.setMaxWidth(Double.MAX_VALUE -10);
            label.setMaxHeight(Double.MAX_VALUE);
            label.setAlignment(Pos.TOP_RIGHT);
            gridPane.add(label,x,y);
            if(++x == 7){
                ++y;
                x=0;
            }
        }
    }
}