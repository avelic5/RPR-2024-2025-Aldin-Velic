import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdavacTest {
    Prodavac p1;

    @BeforeEach
    void beforeAll() {
        p1=new Prodavac(1234,1100,"Mujo","Mujic");

    }


    @Test
    void getBrojStanda() {
        assertEquals(p1.getBrojStanda(),1234);
    }

    @Test
    void setBrojStanda() {
        p1.setBrojStanda(3123);
        assertEquals(p1.getBrojStanda(),3123);
    }

    @Test
    void getiDLicence() {
        assertEquals(p1.getiDLicence(),1100);
    }

    @Test
    void setiDLicence() {
        p1.setiDLicence(3123);
        assertEquals(p1.getiDLicence(),3123);
    }

    @Test
    void getIme() {
        assertEquals(p1.getIme(),"Mujo");
    }

    @Test
    void setIme() {
        p1.setIme("Aldin");
        assertEquals(p1.getIme(),"Aldin");
    }

    @Test
    void getPrezime() {
        assertEquals(p1.getPrezime(),"Mujic");
    }

    @Test
    void setPrezime() {
        p1.setPrezime("Velic");
        assertEquals(p1.getPrezime(),"Velic");
    }

    @Test
    void zdravlje() {
        assertFalse(p1.Zdravlje());
    }
}