package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Predmet {
    private String naziv;
    private Double ECTS;
    private static final SimpleDateFormat dateFormat = new
            SimpleDateFormat("yyyy-MM-dd");

    public Double getECTS() {
        return ECTS;
    }

    public void setECTS(Double ECTS) {
        if(ECTS<5.0||ECTS>20.0)throw new IllegalArgumentException("GR");
       if((ECTS*10)%10!=0&&(ECTS*10)%10!=5)throw new IllegalArgumentException("GR");
        this.ECTS = ECTS;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if(naziv.length()<5||naziv.length()>100)throw new IllegalArgumentException("GR");

        this.naziv = naziv;
    }

    public Predmet(Double ECTS, String naziv) {
        setECTS(ECTS);
        setNaziv(naziv);
    }

    public static List<Predmet> ucitajPredmeteIzTxtDatoteke(String putanjaDoDatoteke) throws IOException, ParseException {
        List<Predmet> predmeti = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(putanjaDoDatoteke));
        String linija;
        while ((linija = reader.readLine()) != null) {
            String[] polja = linija.split(",");
            if (polja.length == 2) {
                Double ECTS = Double.parseDouble(polja[1]);
                String naziv = polja[0];
               Predmet predmet=new Predmet(ECTS,naziv);
                predmeti.add(predmet);
            }
        }
        reader.close();
        return predmeti;
    }

    @Override
    public String toString() {
        return "Predmet{" +
                "ECTS=" + ECTS +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}
