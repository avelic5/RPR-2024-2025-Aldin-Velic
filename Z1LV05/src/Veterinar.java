import java.util.ArrayList;
import java.util.List;

public class Veterinar implements Objekat{
    private String nadimak;
    private Specijalizacija spec;
    private List<Ljubimac> pregledi=new ArrayList<>();

    public Veterinar(String nadimak, Specijalizacija spec) {
        this.nadimak = nadimak;
        this.spec = spec;
    }
    public void PregledajLjubimca(Ljubimac p) throws ValidacijaVrsteException{
        if(p instanceof Macka)throw new ValidacijaVrsteException("greska");
        pregledi.add(p);
    }

    public String getNadimak() {
        return nadimak;
    }

    public void setNadimak(String nadimak) {
        this.nadimak = nadimak;
    }

    public List<Ljubimac> getPregledi() {
        return pregledi;
    }

    public void setPregledi(List<Ljubimac> pregledi) {
        this.pregledi = pregledi;
    }

    public Specijalizacija getSpec() {
        return spec;
    }

    public void setSpec(Specijalizacija spec) {
        this.spec = spec;
    }

    @Override
    public String PrikaziInformacije() {
        return "Veterinar: "+nadimak;
    }
}
