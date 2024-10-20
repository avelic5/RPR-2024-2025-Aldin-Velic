import BazneKlase.Hrana;
import BazneKlase.IInterfejs;

import java.util.Map;
import java.util.TreeMap;

public class Meso extends Hrana implements IInterfejs {
    private VrstaMesa vrsta;
    private String zemljaPorijekla;
    TreeMap<String,Double> nutritivneVrijednosti;

    public VrstaMesa getVrsta() {
        return vrsta;
    }

    public void setVrsta(VrstaMesa vrsta) {
        this.vrsta = vrsta;
    }

    public String getZemljaPorijekla() {
        return zemljaPorijekla;
    }

    public void setZemljaPorijekla(String zemljaPorijekla) {
        this.zemljaPorijekla = zemljaPorijekla;
    }

    public TreeMap<String, Double> getNutritivneVrijednosti() {
        return nutritivneVrijednosti;
    }

    public void setNutritivneVrijednosti(TreeMap<String, Double> nutritivneVrijednosti) {
        this.nutritivneVrijednosti = nutritivneVrijednosti;
    }

    @Override
    public double DajBrojKalorija() {
        double suma=0;
        for(Map.Entry<String,Double> x:nutritivneVrijednosti.entrySet()){
            suma+=x.getValue();
        }
        return 1.2*suma;
    }

    @Override
    public boolean Zdravlje() {
        if(getKoeficijentZdravlja()>0.95)return true;
        return false;
    }

    public Meso(VrstaMesa vrsta, String zemljaPorijekla, TreeMap<String, Double> nutritivneVrijednosti) {
        this.vrsta = vrsta;
        this.zemljaPorijekla = zemljaPorijekla;
        this.nutritivneVrijednosti = nutritivneVrijednosti;
    }

}
