package com.example.lv07.model;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javafx.beans.property.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Osoba {
    private IntegerProperty id;
    private StringProperty ime, prezime, adresa;
    private ObjectProperty<Date> datumRodjenja;
    private StringProperty maticniBroj;
    private ObjectProperty<Uloga> uloga;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Osoba(Integer id, String ime, String prezime, String adresa, Date datumRodjenja, String maticniBroj, Uloga uloga) {
        // inicijalizacija polja
        this.id = new SimpleIntegerProperty(id);
        this.ime = new SimpleStringProperty();
        this.prezime = new SimpleStringProperty(prezime);
        this.adresa = new SimpleStringProperty(adresa);
        this.datumRodjenja = new SimpleObjectProperty<>(datumRodjenja);
        this.maticniBroj = new SimpleStringProperty();
        this.uloga = new SimpleObjectProperty<>(uloga);


        // validacija polja
        setIme(ime);
        setMaticniBroj(maticniBroj);
    }


    public Integer getId() {
        return this.id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public String getIme() {
        return this.ime.get();
    }

    public void setIme(String ime) throws IllegalArgumentException {
        if (ime != null && ime.length() >= 2 && ime.length() <= 50) {
            this.ime.set(ime);
        } else {
            throw new IllegalArgumentException("Ime mora imati izmedju 2 i 50 znakova.");
        }
    }

    public String getPrezime() {
        return prezime.get();
    }


    public StringProperty prezimeProperty() {
        return prezime;
    }


    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }


    public String getAdresa() {
        return this.adresa.get();
    }

    public void setAdresa(String adresa) {
        this.adresa.set(adresa);
    }

    public Date getDatumRodjenja() {
        return this.datumRodjenja.get();
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja.set(datumRodjenja);
    }

    public String getMaticniBroj() {
        return this.maticniBroj.get();
    }

    public boolean ProvjeriMaticniBroj(String maticniBroj) {
        boolean danIsti = this.datumRodjenja.get().getDate() == Integer.parseInt(maticniBroj.substring(0, 2));
        boolean mjesecIsti = this.datumRodjenja.get().getMonth() + 1 == Integer.parseInt(maticniBroj.substring(2, 4));
        boolean godinaIsta = this.datumRodjenja.get().getYear() + 900 == Integer.parseInt(maticniBroj.substring(4, 7));
        return danIsti && mjesecIsti && godinaIsta;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj.set(maticniBroj);
    }

    public Uloga getUloga() {
        return this.uloga.get();
    }

    public void setUloga(Uloga uloga) {
        this.uloga.set(uloga);
    }

    public boolean mozeUcestvovatiUProjektu(boolean voditeljProjekta) {
        return this.uloga.get() == Uloga.NASTAVNO_OSOBLJE || !voditeljProjekta && this.uloga.get() == Uloga.STUDENT;
    }

    public boolean imaPravoNaStipendiju() {
        return this.uloga.get() == Uloga.STUDENT;
    }

    public static List<Osoba> ucitajOsobeIzTxtDatoteke(String putanjaDoDatoteke) throws IOException, ParseException {
        List<Osoba> osobe = new ArrayList();
        BufferedReader reader = new BufferedReader(new FileReader(putanjaDoDatoteke));

        String linija;
        while((linija = reader.readLine()) != null) {
            String[] polja = linija.split(",");
            if (polja.length == 7) {
                Integer id = Integer.parseInt(polja[0]);
                String ime = polja[1];
                String prezime = polja[2];
                String adresa = polja[3];
                Date datumRodjenja = dateFormat.parse(polja[4]);
                String maticniBroj = polja[5];
                Uloga uloga = Uloga.valueOf(polja[6].toUpperCase());
                Osoba osoba = new Osoba(id, ime, prezime, adresa, datumRodjenja, maticniBroj, uloga);
                osobe.add(osoba);
            }
        }

        reader.close();
        return osobe;
    }

    public static List<Osoba> ucitajOsobeIzXmlDatoteke(String putanjaDoDatoteke) throws Exception {
        List<Osoba> osobe = new ArrayList();
        File xmlDatoteka = new File(putanjaDoDatoteke);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(xmlDatoteka);
        doc.getDocumentElement().normalize();
        NodeList listaCvorova = doc.getElementsByTagName("osoba");

        for(int i = 0; i < listaCvorova.getLength(); ++i) {
            Node cvor = listaCvorova.item(i);
            if (cvor.getNodeType() == 1) {
                Element element = (Element)cvor;
                Integer id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                String ime = element.getElementsByTagName("ime").item(0).getTextContent();
                String prezime = element.getElementsByTagName("prezime").item(0).getTextContent();
                String adresa = element.getElementsByTagName("adresa").item(0).getTextContent();
                Date datumRodjenja = dateFormat.parse(element.getElementsByTagName("datumRodjenja").item(0).getTextContent());
                String maticniBroj = element.getElementsByTagName("maticniBroj").item(0).getTextContent();
                Uloga uloga = Uloga.valueOf(element.getElementsByTagName("uloga").item(0).getTextContent().toUpperCase());
                Osoba osoba = new Osoba(id, ime, prezime, adresa, datumRodjenja, maticniBroj, uloga);
                osobe.add(osoba);
            }
        }

        return osobe;
    }

    public StringProperty adresaProperty() {
        return adresa;
    }

    public ObjectProperty<Date> datumRodjenjaProperty() {
        return datumRodjenja;
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty imeProperty() {
        return ime;
    }

    public StringProperty maticniBrojProperty() {
        return maticniBroj;
    }

    public ObjectProperty<Uloga> ulogaProperty() {
        return uloga;
    }

    public String toString() {
        Integer var10000 = this.id.get();
        return "Osoba{id='" + var10000 + "', ime='" + getIme() + "', prezime='" + getPrezime() + "', adresa='" + getAdresa() + "', datumRodjenja=" + String.valueOf(getDatumRodjenja()) + ", maticniBroj='" + getMaticniBroj() + "', uloga=" + String.valueOf(getUloga()) + "}";
    }
}
