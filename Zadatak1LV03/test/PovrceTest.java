import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.TreeMap;

class PovrceTest {

    private Povrce povrce;
    private TreeMap<String, Double> nutritivneVrijednosti;

    @BeforeEach
    void setUp() {
        nutritivneVrijednosti = new TreeMap<>();
        nutritivneVrijednosti.put("Protein", 30.0);
        nutritivneVrijednosti.put("Ugljikohidrati", 50.0);
        nutritivneVrijednosti.put("Masti", 10.0);

        povrce = new Povrce("Solanum lycopersicum", "Italija", nutritivneVrijednosti);
    }

    @Test
    void getLatinskiNaziv() {
        assertEquals("Solanum lycopersicum", povrce.getLatinskiNaziv());
    }

    @Test
    void setLatinskiNaziv() {
        povrce.setLatinskiNaziv("Brassica oleracea");
        assertEquals("Brassica oleracea", povrce.getLatinskiNaziv());
    }

    @Test
    void getZemljaPorijekla() {
        assertEquals("Italija", povrce.getZemljaPorijekla());
    }

    @Test
    void setZemljaPorijekla() {
        povrce.setZemljaPorijekla("Španija");
        assertEquals("Španija", povrce.getZemljaPorijekla());
    }

    @Test
    void getNutritivneVrijednosti() {
        assertEquals(nutritivneVrijednosti, povrce.getNutritivneVrijednosti());
    }

    @Test
    void setNutritivneVrijednosti() {
        TreeMap<String, Double> novaVrijednost = new TreeMap<>();
        novaVrijednost.put("Vlakna", 5.0);
        povrce.setNutritivneVrijednosti(novaVrijednost);
        assertEquals(novaVrijednost, povrce.getNutritivneVrijednosti());
    }

    @Test
    void dajBrojKalorija() {
        assertEquals(90.0, povrce.DajBrojKalorija());
    }

    @Test
    void zdravlje() {
        // Pretpostavljamo da metoda getKoeficijentZdravlja vraća vrijednost 0.6 za ovaj test
        povrce.setKoeficijentZdravlja(0.6); // Postavi odgovarajuću vrijednost koeficijenta
        assertTrue(povrce.Zdravlje());

        povrce.setKoeficijentZdravlja(0.8);
        assertFalse(povrce.Zdravlje());
    }
}
