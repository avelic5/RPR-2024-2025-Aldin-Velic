import model.Osoba;
import model.Uloga;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class testOsoba {


    @Test
    public void konstruktor(){
        Date d=new Date(97,1,25);
       Osoba o=new Osoba(12,"Aldin","Velic","aaa",d,"2502997190028", Uloga.STUDENT);
       assertEquals(o.getIme(),"Aldin");
       assertEquals(o.getAdresa(),"aaa");
       assertEquals(o.getPrezime(),"Velic");
       assertEquals(o.getDatumRodjenja(),d);
       assertEquals(o.getUloga(),Uloga.STUDENT);

    }
    @Test
    public void ime(){
        assertThrows(IllegalArgumentException.class,()->{
            Date d=new Date(104,1,25);
            Osoba o=new Osoba(12,"A","Velic","aaa",d,"2502004190028", Uloga.STUDENT);
        });
    }
    @Test
    public void maticni(){
        assertThrows(IllegalArgumentException.class,()->{
            Date d=new Date(104,1,25);
            Osoba o=new Osoba(12,"A","Velic","aaa",d,"2502004190", Uloga.STUDENT);
        });

    }

    @Test
    public void matdat(){
        assertThrows(IllegalArgumentException.class,()->{
            Date d=new Date(103,1,25);
            Osoba o=new Osoba(12,"A","Velic","aaa",d,"2502004190", Uloga.STUDENT);
        });
    }
    @Test
    public void putanja(){

        assertThrows(IOException.class,()->{
            Osoba.ucitajOsobeIzTxtDatoteke("aa");
        });
    }





}
