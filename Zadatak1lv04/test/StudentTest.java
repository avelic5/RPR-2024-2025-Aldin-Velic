import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
 static Student s1;

    @BeforeAll
    static void beforeAll() {
        Date d=new Date(104,2,25);
         s1=new Student("Aldin","Velic","Ricica, Kakanj",d,"19761",2,9.7);

    }

    @Test
    void dajInformacije() {
        assertEquals(s1.DajInformacije(),"Student: Aldin Velic, broj indeksa: 19761");

    }
}