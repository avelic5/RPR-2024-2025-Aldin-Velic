import BazneKlase.IInterfejs;

public class Prodavac implements IInterfejs {
    private String ime,prezime;
    int brojStanda,iDLicence;

    public Prodavac(int brojStanda, int iDLicence, String ime, String prezime) {
        this.brojStanda = brojStanda;
        this.iDLicence = iDLicence;
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getBrojStanda() {
        return brojStanda;
    }

    public void setBrojStanda(int brojStanda) {
        this.brojStanda = brojStanda;
    }

    public int getiDLicence() {
        return iDLicence;
    }

    public void setiDLicence(int iDLicence) {
        this.iDLicence = iDLicence;
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

    @Override
    public boolean Zdravlje() {
        if(getiDLicence()%100==1)return true;
        return false;
    }
}
