import java.util.Date;

public abstract class Ljubimac implements Objekat{
    protected String ime,opis;
    protected Date rodjenje;

    public Ljubimac(String ime, String opis, Date rodjenje) {
        this.ime = ime;
        this.opis = opis;
        this.rodjenje = rodjenje;
    }
}
