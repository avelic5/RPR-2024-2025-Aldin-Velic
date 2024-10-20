import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.TreeMap;

class VoceTest {

    private Voce voce;
    private TreeMap<String, Double> nutritivneVrijednosti;

    @BeforeEach
    void setUp() {
        nutritivneVrijednosti = new TreeMap<>();
        nutritivneVrijednosti.put("Vitamin C", 20.0);
        nutritivneVrijednosti.put("Šećer", 25.0);
        nutritivneVrijednosti.put("Vlakna", 4.0);

        voce = new Voce("Malus domestica", "Hrvatska", nutritivneVrijednosti);
    }

    @Test
    void getLatinskiNaziv() {
        assertEquals("Malus domestica", voce.getLatinskiNaziv());
    }

    @Test
    void setLatinskiNaziv() {
        voce.setLatinskiNaziv("Citrus sinensis");
        assertEquals("Citrus sinensis", voce.getLatinskiNaziv());
    }

    @Test
    void getZemljaPorijekla() {
        assertEquals("Hrvatska", voce.getZemljaPorijekla());
    }

    @Test
    void setZemljaPorijekla() {
        voce.setZemljaPorijekla("Španija");
        assertEquals("Španija", voce.getZemljaPorijekla());
    }

    @Test
    void getNutritivneVrijednosti() {
        assertEquals(nutritivneVrijednosti, voce.getNutritivneVrijednosti());
    }

    @Test
    void setNutritivneVrijednosti() {
        TreeMap<String, Double> noveVrijednosti = new TreeMap<>();
        noveVrijednosti.put("Antioksidanti", 15.0);
        voce.setNutritivneVrijednosti(noveVrijednosti);
        assertEquals(noveVrijednosti, voce.getNutritivneVrijednosti());
    }

    @Test
    void dajBrojKalorija() {
        assertEquals(49.0, voce.DajBrojKalorija());
    }

    @Test
    void zdravlje() {
        voce.setKoeficijentZdravlja(0.8); // Pretpostavljamo da postoji setter ili metoda za postavljanje koeficijenta zdravlja
        assertTrue(voce.Zdravlje());

        voce.setKoeficijentZdravlja(0.7);
        assertFalse(voce.Zdravlje());
    }
}
