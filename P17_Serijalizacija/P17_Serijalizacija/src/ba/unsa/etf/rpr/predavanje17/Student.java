package ba.unsa.etf.rpr.predavanje17;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Student implements Serializable {
    private String ime;
    private String prezime;
    private int brojIndexa;
    private LocalDate datumRodjenja;

    public Student() {
        datumRodjenja = LocalDate.now();
    }

    public Student(String ime, String prezime, int brojIndexa, LocalDate datumRodjenja) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojIndexa = brojIndexa;
        this.datumRodjenja = datumRodjenja;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(int brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }
}
