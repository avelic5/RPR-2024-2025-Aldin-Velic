import BazneKlase.Hrana;
import BazneKlase.IInterfejs;

import java.util.Map;
import java.util.TreeMap;

public class Voce extends Hrana implements IInterfejs {
   private String latinskiNaziv,zemljaPorijekla;
  private TreeMap<String,Double> nutritivneVrijednosti;
    public Voce(String latinskiNaziv,String zemljaPorijekla,TreeMap<String,Double>nutritivneVrijednosti){
        setLatinskiNaziv(latinskiNaziv);
        setNutritivneVrijednosti(nutritivneVrijednosti);
        setZemljaPorijekla(zemljaPorijekla);
    }
    public String getLatinskiNaziv() {
        return latinskiNaziv;
    }

    public void setLatinskiNaziv(String latinskiNaziv) {
        this.latinskiNaziv = latinskiNaziv;
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
    public  double DajBrojKalorija(){
        double suma=0;
        for(Map.Entry<String,Double> x:nutritivneVrijednosti.entrySet()){
            suma+=x.getValue();
        }
        return suma;
    }
    @Override
    public boolean Zdravlje(){
        if(DajBrojKalorija()<50&&getKoeficijentZdravlja()>0.75)return true;
        return false;
    }



}
