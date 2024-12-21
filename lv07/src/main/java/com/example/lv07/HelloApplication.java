package com.example.lv07;

import com.example.lv07.controller.OsobaController;
import com.example.lv07.model.OsobaModel;
import com.example.lv07.view.OsobaView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class  HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException
    {
        OsobaModel osobaModel = new OsobaModel();


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setController(new OsobaController(osobaModel));


        Scene scene = new Scene(fxmlLoader.load(), 300, 700);
        stage.setTitle("Dodaj osobu!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
        OsobaModel osobaModel = new OsobaModel();
        osobaModel.napuni();


        OsobaView osobaView = new OsobaView();
        osobaView.setUlazniTekst("Novo ime");


        OsobaController osobaController = new OsobaController(osobaModel);
        osobaController.azurirajIme(1);


        System.out.println("1) View ispisuje: " + osobaView.getPoruka());
        System.out.println("   Azurirana osoba je: " + osobaController.dajOsobuPoId(1).toString());



    }
}