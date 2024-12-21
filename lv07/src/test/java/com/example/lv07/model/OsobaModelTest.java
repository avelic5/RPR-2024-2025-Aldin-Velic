package com.example.lv07.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.collections.ObservableList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OsobaModelTest {

    private OsobaModel osobaModel;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @BeforeEach
    void setUp() {
        osobaModel = new OsobaModel();
        osobaModel.napuni();
    }

    @Test
    void testNapuni() {
        ObservableList<Osoba> osobe = osobaModel.dajSveOsobe();
        assertEquals(2, osobe.size(), "Broj osoba nakon punjenja treba biti 2.");
        assertEquals("Neko", osobe.get(0).getIme(), "Ime prve osobe nije ispravno.");
        assertEquals("Neko 2", osobe.get(1).getIme(), "Ime druge osobe nije ispravno.");
    }

    @Test
    void testAzurirajOsobu_Success() throws ParseException {
        // Postavi validne vrijednosti koje se podudaraju s validacijom matičnog broja
        Date noviDatum = dateFormat.parse("1997-08-25");
        String noviMaticniBroj = "2508977123456"; // Validan JMBG za datum 25.08.1997.

        String rezultat = osobaModel.azurirajOsobu(1, "NovoIme", "NovoPrezime", "NovaAdresa", noviDatum, noviMaticniBroj, Uloga.NASTAVNO_OSOBLJE);

        assertEquals("Osoba je uspjesno azurirana!", rezultat, "Poruka nakon uspješnog ažuriranja nije ispravna.");

        Osoba azuriranaOsoba = osobaModel.dajOsobuPoId(1);
        assertNotNull(azuriranaOsoba, "Osoba sa ID 1 treba postojati.");
        assertEquals("NovoIme", azuriranaOsoba.getIme(), "Ime nije ispravno ažurirano.");
        assertEquals("NovoPrezime", azuriranaOsoba.getPrezime(), "Prezime nije ispravno ažurirano.");
        assertEquals("NovaAdresa", azuriranaOsoba.getAdresa(), "Adresa nije ispravno ažurirana.");
        assertEquals(noviDatum, azuriranaOsoba.getDatumRodjenja(), "Datum rođenja nije ispravno ažuriran.");
        assertEquals(noviMaticniBroj, azuriranaOsoba.getMaticniBroj(), "Matični broj nije ispravno ažuriran.");
        assertEquals(Uloga.NASTAVNO_OSOBLJE, azuriranaOsoba.getUloga(), "Uloga nije ispravno ažurirana.");
    }

    @Test
    void testAzurirajOsobu_NotFound() {
        String rezultat = osobaModel.azurirajOsobu(999, "NovoIme", null, null, null, null, null);
        assertEquals("Osoba nije pronadjena!", rezultat, "Poruka za nepostojeću osobu nije ispravna.");
    }

    @Test
    void testDodajOsobu_Success() throws ParseException {
        Date datumRodjenja = dateFormat.parse("2000-05-15");
        String maticniBroj = "1505000123456"; // Validan JMBG za 15.05.2000.

        String rezultat = osobaModel.dodajOsobu(3, "NovaOsoba", "Prezime", "Adresa", datumRodjenja, maticniBroj, Uloga.STUDENT);
        assertEquals("Osoba je uspjesno dodana!", rezultat, "Poruka nakon dodavanja osobe nije ispravna.");

        Osoba novaOsoba = osobaModel.dajOsobuPoId(3);
        assertNotNull(novaOsoba, "Nova osoba sa ID 3 treba postojati.");
        assertEquals("NovaOsoba", novaOsoba.getIme(), "Ime nove osobe nije ispravno.");
        assertEquals(maticniBroj, novaOsoba.getMaticniBroj(), "Matični broj nove osobe nije ispravan.");
    }




}
