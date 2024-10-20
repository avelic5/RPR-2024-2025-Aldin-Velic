import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ulaz;
        PrintWriter izlaz;
        double[] brojevi = new double[1000];
        int vel = 0;

        // Konstruisanje ulaznog toka za datoteku brojevi.txt
        try {
            ulaz = new Scanner(new FileReader("brojevi.txt"));
        } catch(FileNotFoundException e) {
            System.out.println("Datoteka brojevi.txt ne postoji ili se ne može otvoriti.");
            System.out.println("Greška: " + e);
            return; // kraj programa
        }

        // Konstruisanje izlaznog toka za datoteku sortirano.txt
        try {
            izlaz = new PrintWriter(new FileWriter("sortirano.txt"));
        } catch(IOException e) {
            System.out.println("Datoteka sortirano.txt se ne može otvoriti za pisanje.");
            System.out.println("Greška: " + e);
            ulaz.close(); // Najprije moramo zatvoriti ulaznu datoteku
            return;
        }

        try {
            // Učitavamo brojeve
            while (ulaz.hasNext()) {
                brojevi[vel] = ulaz.nextDouble();
                vel = vel + 1;
                if (vel == 1000) break;
            }

            // Sortiranje
            Arrays.sort(brojevi, 0, vel);

            // Upisivanje u izlaznu datoteku
            for (int i = 0; i < vel; i++)
                izlaz.println(brojevi[i]);

            System.out.println("Datoteka brojevi.txt je sortirana.");

        } catch(Exception e) {
            System.out.println("Problem pri čitanju/pisanju podataka.");
            System.out.println("Greška: " + e);

        } finally {
            // Bez obzira došlo do izuzetka ili ne, datoteke treba zatvoriti
            ulaz.close();
            izlaz.close();
        }

    }
}
