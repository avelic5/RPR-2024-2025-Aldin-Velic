package com.example.demo2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {

        ObservableList<Integer> brojevi = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);//stavljamo brojeve u oblista
        ListView<Integer> listView = new ListView<>(brojevi);
        listView.setOnMouseClicked(event -> {int izabranindex = listView.getSelectionModel().getSelectedIndex();
                //gledamo index, obratimo paznju na ono sta trazi
            if (izabranindex != -1) { int velicina = brojevi.size();
                int trenutni = brojevi.get(izabranindex);
                int sljedeci = (izabranindex + 1) % velicina;
                int prethodni = (izabranindex - 1 +velicina) % velicina;
                int n = brojevi.get(sljedeci);
                int p = brojevi.get(prethodni);
                if (trenutni > n && trenutni>p) {//????
                    brojevi.set(sljedeci,p);
                    brojevi.set(prethodni,trenutni);
                }

               else if (trenutni < n) {
                    brojevi.set(izabranindex, n);
                    brojevi.set(sljedeci, trenutni);
                }
            }
        });


        BorderPane root = new BorderPane(listView);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("POKAZNI ZADATAK");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}