import com.sun.source.tree.Tree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class MesoTest {

    Meso piletina;

    @BeforeEach
    void setUp() {
        TreeMap<String,Double>m=new TreeMap<>();
        m.put("Cuker",23.);
        m.put("Proteini",54.);
      piletina=new Meso(VrstaMesa.PILETINA,"BiH",m);
    }



    @Test
    void getVrsta() {
        assertEquals(VrstaMesa.PILETINA,piletina.getVrsta());


    }

    @Test
    void setVrsta() {
        piletina.setVrsta(VrstaMesa.JANJETINA);
        assertEquals(VrstaMesa.JANJETINA,piletina.getVrsta());
    }

    @Test
    void getZemljaPorijekla() {
        assertEquals(piletina.getZemljaPorijekla(),"BiH");
    }

    @Test
    void setZemljaPorijekla() {
        piletina.setZemljaPorijekla("Hrvatska");
        assertEquals(piletina.getZemljaPorijekla(),"Hrvatska");
    }

    @Test
    void getNutritivneVrijednosti() {
        var provjera=piletina.getNutritivneVrijednosti();
       assertEquals(provjera,piletina.getNutritivneVrijednosti());

    }

    @Test
    void setNutritivneVrijednosti() {
        TreeMap<String,Double> provjera=new TreeMap<>();
        provjera.put("Cuker2",31.);
        provjera.put("Proteini2",54.);
        piletina.setNutritivneVrijednosti(provjera);
       assertEquals(piletina.getNutritivneVrijednosti(),provjera);
    }

    @Test
    void dajBrojKalorija() {

        assertEquals(piletina.DajBrojKalorija(),1.2*77);
    }

    @Test
    void zdravlje() {
        piletina.setKoeficijentZdravlja(0.8);
        assertFalse(piletina.Zdravlje());

        ;
    }
}