import Izuzeci.PremladStudentException;
import Izuzeci.StudentBuducnostException;
import Klase.Odsjek;
import Klase.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean uspjesanUnos = false;
        Student student = null;
        while (!uspjesanUnos) {
            try {
                System.out.printf("Datum rođenja (dd/mm/yyyy):");
                String datumString = scanner.nextLine();
                int godina = Integer.valueOf(datumString.substring(6)) - 1900;
                int mjesec = Integer.valueOf(datumString.substring(3, 5)) - 1;
                int dan = Integer.valueOf(datumString.substring(0, 2));
                Date datumDate = new Date(godina, mjesec, dan);
                student = new Student("Ime", "Prezime", datumDate, "12345", Odsjek.RI, 2);
                uspjesanUnos = true;
            } catch (PremladStudentException e) {
                System.out.println(e.getMessage());
                return;
            } catch (StudentBuducnostException e) {
                System.out.println(e.getMessage());
                System.out.println("Molimo ponovite unos datuma rođenja!");
            }
        }
        List<Integer> lista=new ArrayList<Integer>();
        System.out.print("Unesite ocjene(x,y,...): ");
        Scanner ulaz=new Scanner(System.in);
        String pomocna=ulaz.nextLine();
        for(String x:pomocna.split(","))
            lista.add(Integer.valueOf(x));
        student.setOcjene(lista);

        System.out.println("Unos studenta uspjesan!"+student);
    }
}
