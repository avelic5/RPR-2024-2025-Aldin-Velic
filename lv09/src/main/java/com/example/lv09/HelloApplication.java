package com.example.lv09;

import controller.OsobaController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.OsobaModel;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        OsobaModel osobaModel = OsobaModel.getInstance();

        // Učitaj .fxml datoteku
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        // Poveži kontroler s FXMLLoader-om
        fxmlLoader.setController(new OsobaController(osobaModel));

        // Kreiraj scenu
        Scene scene = new Scene(fxmlLoader.load(), 300, 700);
        stage.setTitle("Dodaj osobu!");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args); // Pokreće JavaFX aplikaciju
    }
}