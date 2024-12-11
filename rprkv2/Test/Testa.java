import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Testa {


    @Test
    public void test4(){
        Vektor v2=new Vektor(1,2);
        v2.setX(1);
        v2.setY(2);

        Vektor v1=new Vektor();
        v1.setX(3);
        v1.setY(4);
        v1.dodaj(v2);
        //assertEquals(v1,v2);
        assertEquals(4,v1.getX());
        assertEquals(6,v1.getY());

    }

    @Test
    public void Test3(){
        Vektor v2=new Vektor(1,2);
        v2.setX(1);
        v2.setY(2);

        Vektor v1=new Vektor();
        v1.setX(3);
        v1.setY(4);
        v1.dodajAkoJePozitivan(v2);
        assertEquals(4,v1.getX());
        assertEquals(6,v1.getY());
        v1.setX(3);
        v1.setY(4);
        v2.setX(-4);
        v2.setY(2);
        v1.dodajAkoJePozitivan(v2);
        assertEquals(3,v1.getX());
        assertEquals(4,v1.getY());
        v1.setX(3);
        v1.setY(-4);
        v2.setX(4);
        v2.setY(2);
        v1.dodajAkoJePozitivan(v2);
        assertEquals(3,v1.getX());
        assertEquals(-4,v1.getY());

    }

}