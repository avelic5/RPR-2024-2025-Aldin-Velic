import BazneKlase.Hrana;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // Kreiranje objekata za različite klase
        TreeMap<String,Double>nutritivneVrijednosti=new TreeMap<>();
        nutritivneVrijednosti.put("Ugljikohidrati",23.);
        nutritivneVrijednosti.put("Proteini",53.);
        nutritivneVrijednosti.put("Vitamini",42.);


        Hrana jabuka=new Voce("jabuka","BiH",nutritivneVrijednosti);
        Hrana krompir=new Povrce("krompir","Srbija",nutritivneVrijednosti);
        Prodavac pd1=new Prodavac( 12,17701,"Kemo","Kundo");
        Hrana piletina=new Meso(VrstaMesa.PILETINA,"BiH",nutritivneVrijednosti);





        // Ispis broja kalorija i zdravlja za Voce
        System.out.println("Voce: Jabuka");
        System.out.println("Broj kalorija: " + jabuka.DajBrojKalorija());
        System.out.println("Zdravo: " + jabuka.Zdravlje());

        // Ispis broja kalorija i zdravlja za Povrce
        System.out.println("\nPovrce: Krompir");
        System.out.println("Broj kalorija: " + krompir.DajBrojKalorija());
        System.out.println("Zdravo: " + krompir.Zdravlje());

        // Ispis broja kalorija i zdravlja za Meso
        System.out.println("\nMeso: Piletina");
        System.out.println("Broj kalorija: " + piletina.DajBrojKalorija());
        System.out.println("Zdravo: " + piletina.Zdravlje());

        // Ispis zdravlja za Prodavca
        System.out.println("\nProdavac: " + pd1.getIme() + " " + pd1.getPrezime());
        System.out.println("Zdravo: " + pd1.Zdravlje());
    }
}