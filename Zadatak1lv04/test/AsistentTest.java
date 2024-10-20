import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
public class AsistentTest {
    Asistent a1;

    @Test
    public void testKonstruktora(){
        Date d=new Date(104,2,25);
        a1=new Asistent("Aldin", "Velic","/",d,1234,2004,"/"
        ,"1-22","15:00");
        assertEquals(a1.DajInformacije(),"Asistent: Aldin Velic");
    }
  
}