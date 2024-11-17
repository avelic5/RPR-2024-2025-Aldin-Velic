import java.util.Date;

public class Macka extends Ljubimac implements Objekat{
    private VrstaMacke vrsta;

    public Macka(String ime,  Date rodjenje,String opis, VrstaMacke vrsta) {
        super(ime, opis, rodjenje);
        this.vrsta = vrsta;
    }

    @Override
    public String PrikaziInformacije() {
        return "Mačka: "+vrsta;
    }
}
