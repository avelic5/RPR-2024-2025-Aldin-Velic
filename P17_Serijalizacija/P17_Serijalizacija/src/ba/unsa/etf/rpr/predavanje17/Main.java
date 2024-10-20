package ba.unsa.etf.rpr.predavanje17;

import java.beans.*;
import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Main {
    static void zapisiBinarno(Fakultet f) {
        try {
            ObjectOutputStream izlaz = new ObjectOutputStream(new FileOutputStream("fakultet.dat"));
            izlaz.writeObject(f);
            izlaz.close();
        } catch(Exception e) {
            System.out.println("Greška: "+e);
        }
    }

    static Fakultet ucitajBinarno() {
        Fakultet f = null;
        try {
            ObjectInputStream ulaz = new ObjectInputStream(new FileInputStream("fakultet.dat"));
            f = (Fakultet) ulaz.readObject();
            ulaz.close();
        } catch(Exception e) {
            System.out.println("Greška: "+e);
        }
        return f;
    }

    static Fakultet ucitajXml() {
        Fakultet f = null;
        try {
            XMLDecoder ulaz = new XMLDecoder(new FileInputStream("fakultet.xml"));
            f = (Fakultet) ulaz.readObject();
            ulaz.close();
        } catch(Exception e) {
            System.out.println("Greška: "+e);
        }
        return f;
    }

    static void zapisiXml(Fakultet f) {
        try {
            XMLEncoder izlaz = new XMLEncoder(new FileOutputStream("fakultet.xml"));
            /*izlaz.setPersistenceDelegate(LocalDate.class,
                new PersistenceDelegate() {
                    @Override
                    protected Expression instantiate(Object localDate, Encoder encdr) {
                        return new Expression(localDate,
                                LocalDate.class,
                                "parse",
                                new Object[]{localDate.toString()});
                    }
                });*/
            izlaz.writeObject(f);
            izlaz.close();
        } catch(Exception e) {
            System.out.println("Greška: "+e);
        }
    }

    public static void main(String[] args) {
	    Fakultet f = new Fakultet();
	    f.upisi(new Student("Meho", "Mehic", 12345, LocalDate.of(1990, Month.JANUARY, 1)));
        f.upisi(new Student("Pero", "Peric", 12346, LocalDate.of(1991, Month.FEBRUARY, 28)));
        f.upisi(new Student("Sara", "Sarac", 23451, LocalDate.of(1992, Month.DECEMBER, 1)));

        Scanner s = new Scanner(System.in);

        boolean kraj = false;
        while(!kraj) {
            System.out.println("Unesite opciju:\n" +
                " 1 - Učitaj fakultet binarno\n" +
                " 2 - Zapiši fakultet binarno\n" +
                " 3 - Učitaj fakultet XML\n" +
                " 4 - Zapiši fakultet XML\n" +
                " 0 - Kraj"
            );
            int x = s.nextInt();
            switch(x) {
                case 1:
                    f = ucitajBinarno();
                    break;
                case 2:
                    zapisiBinarno(f);
                    break;
                case 3:
                    f = ucitajXml();
                    break;
                case 4:
                    zapisiXml(f);
                    break;
                case 0:
                    kraj = true;
            }
        }
        zapisiBinarno(f);
    }
}
