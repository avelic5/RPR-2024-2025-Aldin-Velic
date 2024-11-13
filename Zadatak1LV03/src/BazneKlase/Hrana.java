package BazneKlase;

public abstract class Hrana implements IInterfejs {
    protected double koeficijentZdravlja;
    protected double brojKalorija;
    public abstract double DajBrojKalorija();
    public abstract boolean Zdravlje();
    public Hrana(){}
    public double getKoeficijentZdravlja() {
        return koeficijentZdravlja;
    }

    public void setKoeficijentZdravlja(double koeficijentZdravlja) {
        this.koeficijentZdravlja = koeficijentZdravlja;
    }

    public double getBrojKalorija() {
        return brojKalorija;
    }

    public void setBrojKalorija(int brojKalorija) {
        this.brojKalorija = brojKalorija;
    }
}
