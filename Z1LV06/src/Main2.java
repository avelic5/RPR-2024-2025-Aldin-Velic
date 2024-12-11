import controller.OsobaController;
import model.Osoba;
import model.Uloga;
import view.OsobaView;
import controller.*;
import model.*;

import java.util.Date;

public class Main2 {
    public static void main(String[] args) {
        Predmet predmet=new Predmet(15.,"Matematika");



        OsobaView osobaView = new OsobaView();


        osobaView.setUlazniTekst("Fizika,16.5");
        PredmetController predmetController = new PredmetController(predmet, osobaView);


        predmetController.azuriraj();


        System.out.println("1) View ispisuje: " + osobaView.getPoruka());
        predmetController.dajPredmeteIzTxtDatoteke("src/data/predmeti.txt");
        System.out.println("2) View ispisuje: " + osobaView.getPoruka());



    }
}