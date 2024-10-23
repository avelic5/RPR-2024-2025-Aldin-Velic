import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> lista = new ArrayList<Double>();
        String operacija = null;
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite operaciju");
        operacija = ulaz.nextLine();
        Double n = 0.;
        System.out.println("Unesite sada elemente, -400 označava kraj");

        while (n != 400) {
            n = ulaz.nextDouble();
            if (n == -400) break;
            lista.add(n);}
            Double rez = 0.;

            if ("saberi".equals(operacija)) {

                if (lista.isEmpty()) return;

                try {
                    for (var x : lista) rez = Plus(rez,  x);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else {
                if (lista.isEmpty()) return;

                try {
                    rez=lista.get(0);
                    for (int i=1;i<lista.size();i++) rez = Podijeljeno(rez,lista.get(i));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }


            }



        System.out.println(rez);
    }

        public static Double Plus (Double broj1, Double broj2){
            return broj1 + broj2;
        }
        public static Double Podijeljeno (Double broj1, Double broj2) throws Exception {
            if (broj2 == 0) throw new Exception("Dijeljenje s nulom nema smisla");
            return  (Math.round((broj1 / broj2) * 100.) / 100.);

        }


}
