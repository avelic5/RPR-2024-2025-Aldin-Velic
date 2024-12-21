package com.example.lv07.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import com.example.lv07.model.Osoba;
import com.example.lv07.model.OsobaModel;
import com.example.lv07.model.Uloga;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class OsobaController {

    @FXML
    private Label ucitavanjeLabel;
    @FXML
    private ListView<Osoba> osobeListView;
    @FXML
    private TextField imeField;
    @FXML
    private TextField prezimeField;
    @FXML
    private TextField adresaField;
    @FXML
    private DatePicker datumRodjenjaPicker;
    @FXML
    private TextField maticniBrojField;
    @FXML
    private ChoiceBox<Uloga> ulogaChoiceBox;
    @FXML
    private Button azurirajOsobuButton;
    @FXML
    private Label porukaLabel;

    private OsobaModel model;
    private ObservableList<Osoba> osobeObservableList = FXCollections.observableArrayList();

    // Koristi ObjectProperty za izabranu osobu
    private ObjectProperty<Osoba> izabranaOsoba = new SimpleObjectProperty<>();

    public OsobaController(OsobaModel model) {
        this.model = model;
    }

    @FXML
    public void initialize() {
        model.napuni();

        ucitavanjeLabel.setText("Ucitani podaci");
        ucitavanjeLabel.setStyle("-fx-background-color: green;");

        azurirajOsobuButton.setText("Azuriraj");

        ulogaChoiceBox.getItems().addAll(Uloga.STUDENT, Uloga.NASTAVNO_OSOBLJE);

        // Popunjava listu sa osobama iz modela
        osobeObservableList.addAll(model.dajSveOsobe());
        osobeListView.setItems(osobeObservableList);

        // Event handler za azuriranje osobe
        azurirajOsobuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                azurirajOsobu();
            }
        });

        // Event listener za selektovanje osobe iz ListView
        osobeListView.getSelectionModel().selectedItemProperty().addListener((observable, staraVrijednost, novaVrijednost) -> {
            if (novaVrijednost != null) {
                // Azuriraj varijablu koja predstavlja trenutno izabranu osobu
                izabranaOsoba.setValue(novaVrijednost); // Koristimo setValue() umesto dodele direktno
                // Ispunjavanje polja detaljima izabrane osobe
                ispuniPolja(novaVrijednost);
                // Sakrij labelu koja sadrži poruku
                porukaLabel.setVisible(false);
            }
        });

        // Dodajemo eventListener za izabranuOsobu
        izabranaOsoba.addListener((observable, oldValue, newValue) -> {
            if (oldValue != null) {
                // Uklanjamo vezu sa prethodnim objektom
                imeField.textProperty().unbindBidirectional(oldValue.imeProperty());
                prezimeField.textProperty().unbindBidirectional(oldValue.prezimeProperty());
            }
            if (newValue != null) {
                // Povezujemo novo izabranu osobu sa input poljima
                imeField.textProperty().bindBidirectional(newValue.imeProperty());
                prezimeField.textProperty().bindBidirectional(newValue.prezimeProperty());
            }
        });
    }

    // Ispunjavanje input polja sa podacima iz izabrane osobe
    private void ispuniPolja(Osoba osoba) {
        imeField.setText(osoba.getIme());
        prezimeField.setText(osoba.getPrezime());
        adresaField.setText(osoba.getAdresa());
        datumRodjenjaPicker.setValue(osoba.getDatumRodjenja().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        maticniBrojField.setText(osoba.getMaticniBroj());
        ulogaChoiceBox.setValue(osoba.getUloga());
    }

    // Metoda za ažuriranje podataka izabrane osobe
    private void azurirajOsobu() {
        if (izabranaOsoba.get() != null) { // Koristi get() da pristupiš vrednosti
            // Pročitaj sadržaj input polja
            String ime = imeField.getText();
            String prezime = prezimeField.getText();
            String adresa = adresaField.getText();
            LocalDate datumRodjenjaLocal = datumRodjenjaPicker.getValue();
            String maticniBroj = maticniBrojField.getText();
            Uloga uloga = ulogaChoiceBox.getValue();

            // Validacija polja forme
            if (ime.isEmpty() || prezime.isEmpty() || adresa.isEmpty() || maticniBroj.isEmpty() || datumRodjenjaLocal == null || uloga == null) {
                porukaLabel.setVisible(true);
                porukaLabel.setText("Sva polja moraju biti popunjena!");
                return;
            }

            Date datumRodjenja = Date.from(datumRodjenjaLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
            // Pozivanje modela za ažuriranje osobe
            String poruka = model.azurirajOsobu(izabranaOsoba.get().getId(), ime, prezime, adresa, datumRodjenja, maticniBroj, uloga);
            porukaLabel.setVisible(true);
            porukaLabel.setText(poruka);
            osobeListView.refresh();
        }
    }
    public String azurirajIme(int id) {
        Osoba osoba = dajOsobuPoId(id);
        if (osoba != null) {

            osoba.setIme("NovoIme");
            String poruka = model.azurirajOsobu(osoba.getId(), osoba.getIme(), osoba.getPrezime(), osoba.getAdresa(), osoba.getDatumRodjenja(), osoba.getMaticniBroj(), osoba.getUloga());
            return poruka;
        } else {
            return "Osoba sa id " + id + " nije pronađena!";
        }
    }

    // Metoda koja vraća osobu po ID-u
    public Osoba dajOsobuPoId(int id) {
        for (Osoba osoba : model.dajSveOsobe()) {
            if (osoba.getId() == id) {
                return osoba;
            }
        }
        return null;
    }
}