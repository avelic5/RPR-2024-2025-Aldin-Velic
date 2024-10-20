package com.example.predmet.controller;

import com.example.predmet.model.Predmet;
import com.example.predmet.model.PredmetModel;
import javafx.collections.ObservableList;

public class PredmetController {

    private PredmetModel predmetModel;

    public PredmetController() {
        predmetModel = new PredmetModel();
    }

    // Dodavanje novog predmeta
    public String dodajPredmet(String naziv, Double ECTS) {
        try {
            predmetModel.dodajPredmet(naziv, ECTS);
            return "Predmet je uspješno dodat!";
        } catch (IllegalArgumentException e) {
            return e.getMessage(); // Ako postoji greška pri unosu predmeta
        }
    }

    // Ažuriranje postojećeg predmeta
    public String azurirajPredmet(int id, String naziv, Double ECTS) {
        return predmetModel.azurirajPredmet(id, naziv, ECTS);
    }

    // Brisanje predmeta
    public String obrisiPredmet(int id) {
        return predmetModel.obrisiPredmet(id);
    }

    // Prikaz svih predmeta
    public ObservableList<Predmet> dajSvePredmete() {
        return predmetModel.dajSvePredmete();
    }

}
