package com.example.aron;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {///escolher sempre no codigo o fx:controller="com.example.aron.HelloController">
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
       /* InputStream stream = new FileInputStream("/C:/Users/manec/Desktop/IHC/Aron/src/main/java/com/example/aron/imagemDaFormula.jpg");
        Image image=new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        Group root = new Group(imageView);*/
        Scene scene = new Scene(fxmlLoader.load(), 626, 320);
        stage.setTitle("Heron!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
