package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import model.Osoba;
import model.OsobaModel;
import model.Uloga;

import static com.example.lv09.Database.connect;

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
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private void ucitajOsobeIzBaze() {
        List<Osoba> osobe = OsobaModel.dajSveOsobe();
        osobeObservableList.setAll(osobe);
    }



    // Koristi ObjectProperty za izabranu osobu
    private ObjectProperty<Osoba> izabranaOsoba = new SimpleObjectProperty<>();

    public OsobaController(OsobaModel model) {
        this.model = model;
    }


    @FXML
    public void initialize() {
        OsobaModel.kreirajTabeluAkoNePostoji();
        OsobaModel.isprazniTabeluOsoba();
        OsobaModel.napuniInicijalnimPodacima();
        ucitavanjeLabel.setText("Ucitani podaci");
        ucitavanjeLabel.setStyle("-fx-background-color: green;");



        azurirajOsobuButton.setText("Azuriraj");


        ulogaChoiceBox.getItems().addAll(Uloga.STUDENT, Uloga.NASTAVNO_OSOBLJE);


        ucitajOsobeIzBaze();
        osobeListView.setItems(osobeObservableList);


        // dodavanje listener-a za klik dugmeta
        azurirajOsobuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                azurirajOsobu();
            }
        });


        // dodavanje listener-a za izbor osobe iz listview
        osobeListView.getSelectionModel().selectedItemProperty().addListener((observable, starVrijednost, novaVrijednost) -> {
            if (novaVrijednost != null) {
                izabranaOsoba.set(novaVrijednost);  // azuriranje varijable koja predstavlja trenutno izabranu osobu
                ispuniPolja(novaVrijednost);  // ispunjavanje polja detaljima izabrane osobe
                porukaLabel.setVisible(false); // sakrij labelu koja sadrzi poruku
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