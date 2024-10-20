package com.example.predmet.model;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PredmetModel {

    private ObservableList<Predmet> predmeti;

    public PredmetModel() {
        predmeti = FXCollections.observableArrayList();
    }

    // CREATE: Dodavanje novog predmeta
    public String dodajPredmet(Double ECTS, String naziv) {
        if (ECTS < 5.0 || ECTS > 20.0) {
            return "ECTS mora biti između 5 i 20.";
        }
        if (naziv == null || naziv.length() < 5 || naziv.length() > 100) {
            return "Naziv predmeta mora imati između 5 i 100 znakova.";
        }
        Predmet predmet = new Predmet(ECTS, naziv);
        predmeti.add(predmet);
        return "Predmet je uspješno dodan!";
    }

    // READ: Dohvaćanje svih predmeta
    public ObservableList<Predmet> dajSvePredmete() {
        return predmeti;
    }

    // READ: Dohvaćanje predmeta prema nazivu
    public Predmet dajPredmetPoNazivu(String naziv) {
        for (Predmet predmet : predmeti) {
            if (predmet.getNaziv().equalsIgnoreCase(naziv)) {
                return predmet;  // Vraća predmet ako je pronađen
            }
        }
        return null;  // Vraća null ako predmet nije pronađen
    }

    // UPDATE: Ažuriranje postojećeg predmeta
    public String azurirajPredmet(String naziv, Double noviECTS, String noviNaziv) {
        Predmet predmet = dajPredmetPoNazivu(naziv);

        if (predmet != null) {
            if (noviECTS != null) {
                predmet.setECTS(noviECTS);
            }
            if (noviNaziv != null && !noviNaziv.trim().isEmpty()) {
                predmet.setNaziv(noviNaziv);
            }
            return "Predmet je uspješno ažuriran!";
        }
        return "Predmet s nazivom '" + naziv + "' nije pronađen!";
    }

    // DELETE: Brisanje predmeta prema nazivu
    public String obrisiPredmet(String naziv) {
        Predmet predmet = dajPredmetPoNazivu(naziv);
        if (predmet != null) {
            predmeti.remove(predmet);
            return "Predmet je uspješno obrisan!";
        }
        return "Predmet s nazivom '" + naziv + "' nije pronađen!";
    }
}
