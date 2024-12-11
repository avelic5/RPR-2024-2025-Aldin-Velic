import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class VariantTest {

    @Test
    public void provjera(){
        Variant v=new Variant(3,2,5,1);
        assertEquals(8,v.sracunaj());
        Variant v2=new Variant(3,2,0,0);
        assertEquals(5,v2.sracunaj());
        Variant v3=new Variant(3,2,1,4);
        assertEquals(7,v3.sracunaj());
        Variant v4=new Variant(3,2,1,1);
        assertEquals(4,v4.sracunaj());
        Variant v5=new Variant(1,2,3,4);
        assertEquals(7,v5.sracunaj());
        Variant v6=new Variant(1,1,2,3);
        assertEquals(0,v6.sracunaj());

    }

}