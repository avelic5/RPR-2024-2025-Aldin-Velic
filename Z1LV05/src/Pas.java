import java.util.Date;

public class Pas  extends Ljubimac implements Objekat {
    private VrstaPsa vrsta;

    public Pas(String ime,  Date rodjenje, String opis,VrstaPsa vrsta) {
        super(ime, opis, rodjenje);
        this.vrsta = vrsta;
    }

    public VrstaPsa getVrsta() {
        return vrsta;
    }

    public void setVrsta(VrstaPsa vrsta) {
        this.vrsta = vrsta;
    }

    @Override
    public String PrikaziInformacije() {
        return "Pas: "+vrsta;
    }
}
