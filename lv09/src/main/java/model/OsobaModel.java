package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileReader;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static com.example.lv09.Database.connect;


public class OsobaModel
{
    private static ObservableList<Osoba> osobe;
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final String DATABASE_URL = "jdbc:sqlite:baza.db";
    private static OsobaModel instance = null;


    public static OsobaModel getInstance() {
        if (instance == null) {
            instance = new OsobaModel();
        }
        return instance;
    }


    public static void removeInstance() {
        instance = null;
    }

    private OsobaModel() {
        osobe = FXCollections.observableArrayList();
    }
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }




    public String dodajOsobu(Integer id, String ime, String prezime, String adresa, Date datumRodjenja, String maticniBroj, Uloga uloga) {
        try {
            Osoba newOsoba = new Osoba(id, ime, prezime, adresa, datumRodjenja, maticniBroj, uloga);
            osobe.add(newOsoba);
            return "Osoba je uspjesno dodana!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
    public static ObservableList<Osoba> dajSveOsobe() {
        return osobe;
    }
    public static void kreirajTabeluAkoNePostoji() {
        String kreirajOsobaTabeluSql = """
      CREATE TABLE IF NOT EXISTS Osoba (
          id INTEGER,
          ime TEXT,
          prezime TEXT,
          adresa TEXT,
          datumRodjenja TEXT,
          maticniBroj TEXT,
          uloga TEXT
      );
   """;


        try (
                Connection conn = connect();
                Statement stmt = conn.createStatement()) {
            stmt.execute(kreirajOsobaTabeluSql);
            System.out.println("Tabela je kreirana ili vec postoji!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void napuniInicijalnimPodacima() {
        String insertSQL = """
      INSERT INTO Osoba (id, ime, prezime, adresa, datumRodjenja, maticniBroj, uloga)
      VALUES (?, ?, ?, ?, ?, ?, ?);
   """;


        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {


            pstmt.setInt(1, 1);
            pstmt.setString(2, "John");
            pstmt.setString(3, "Doe");
            pstmt.setString(4, "Some Address");
            pstmt.setString(5, "1995-01-15");
            pstmt.setString(6, "1501995123456");
            pstmt.setString(7, "STUDENT");
            pstmt.executeUpdate();


            pstmt.setInt(1, 2);
            pstmt.setString(2, "Alice");
            pstmt.setString(3, "Alister");
            pstmt.setString(4, "Another Address");
            pstmt.setString(5, "1980-05-20");
            pstmt.setString(6, "2005980444444");
            pstmt.setString(7, "NASTAVNO_OSOBLJE");
            pstmt.executeUpdate();


            System.out.println("Ubaceni pocetni podaci!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void isprazniTabeluOsoba() {
        String upit = "DELETE FROM Osoba";


        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            int brojObrisanihRedova = stmt.executeUpdate(upit);
            System.out.println("Obrisani redovi tabele. Broj obrisanih redova: " + brojObrisanihRedova);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Osoba dajOsobuPoId(Integer id) {
        for (Osoba osoba : osobe) {
            if (osoba.getId().equals(id)) {
                return osoba;
            }
        }
        return null;
    }
    public String obrisiOsobuPoId(Integer id){
        try{if(osobe.removeIf((osoba) -> osoba.getId().equals(id)))return "Osoba je uspjesno obrisana!";
                else return "Osoba nije pronadjena!";}
        catch(Exception e){return e.getMessage();}

    }
    public String azurirajOsobu(Integer id, String novoIme, String novoPrezime, String novaAdresa, Date noviDatumRodjenja, String noviMaticniBroj, Uloga novaUloga)
    {
        Osoba trazenaOsoba = dajOsobuPoId(id);
        if(trazenaOsoba != null) {
            try {
                if (novoIme != null&& !novoIme.isEmpty()) {

                    trazenaOsoba.setIme(novoIme);
                }
                if (novoPrezime != null) {
                    trazenaOsoba.setPrezime(novoPrezime);
                }
                if (novaAdresa != null) {
                    trazenaOsoba.setAdresa(novaAdresa);
                }
                if (noviDatumRodjenja != null) {
                    trazenaOsoba.setDatumRodjenja(noviDatumRodjenja);
                }
                if (noviMaticniBroj != null&& trazenaOsoba.ProvjeriMaticniBroj(noviMaticniBroj)) {
                    trazenaOsoba.setMaticniBroj(noviMaticniBroj);
                }
                if (novaUloga != null){
                    trazenaOsoba.setUloga(novaUloga);
                }
                return "Osoba je uspjesno azurirana!";
            }
            catch (IllegalArgumentException e) {
                return e.getMessage();
            }
        }
        return "Osoba nije pronadjena!";
    }
    public String obrisiOsobu(Integer id)
    {
        if(osobe.removeIf((osoba) -> osoba.getId() == id))return "Osoba je uspjesno obrisana!";
        return "Osoba nije pronadjena";

    }

    public void napuni(){
        osobe.add(new Osoba(1,"Neko","Nekic","Neka adresa", new Date(97,8,25), "2509997123456", Uloga.STUDENT));
        osobe.add(new Osoba(2,"Neko 2","Nekic 2","Neka adresa 2",new Date(97,8,25), "2509997123456", Uloga.NASTAVNO_OSOBLJE));
    }

    public void napuniPodatkeIzTxtDatoteke(String putanjaDoDatoteke) throws IOException, ParseException {
        osobe = FXCollections.observableArrayList();
        BufferedReader reader = new BufferedReader(new FileReader(putanjaDoDatoteke));


        String linija;
        while ((linija = reader.readLine()) != null) {
            String[] polja = linija.split(",");
            if (polja.length == 7) {
                Integer id = Integer.parseInt(polja[0]);
                String ime = polja[1];
                String prezime = polja[2];
                String adresa = polja[3];
                Date datumRodjenja = dateFormat.parse(polja[4]);
                String maticniBroj = polja[5];
                Uloga uloga = Uloga.valueOf(polja[6].toUpperCase());


                Osoba osoba = new Osoba(id, ime, prezime, adresa, datumRodjenja, maticniBroj,uloga);
                osobe.add(osoba);
            }
        }
        reader.close();
    }
    public void napuniPodatkeIzXmlDatoteke(String putanjaDoDatoteke) throws Exception
    {
        osobe = FXCollections.observableArrayList();
        File xmlFile = new File(putanjaDoDatoteke);


        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(xmlFile);


        doc.getDocumentElement().normalize();


        NodeList listaCvorova = doc.getElementsByTagName("osoba");


        for (int i = 0; i < listaCvorova.getLength(); i++)
        {
            Node cvor = listaCvorova.item(i);


            if (cvor.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) cvor;


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
    }







}