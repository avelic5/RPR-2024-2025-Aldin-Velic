package ba.unsa.etf.rpr.predavanje17;

import java.io.Serializable;
import java.util.ArrayList;

public class Fakultet implements Serializable {
    ArrayList<Student> studenti = new ArrayList<Student>();

    void upisi(Student s) {
        studenti.add(s);
    }

    Student dajStudenta(String ime, String prezime) {
        for (Student s : studenti)
            if (s.getIme().equals(ime) && s.getPrezime().equals(prezime))
                return s;
        return null;
    }

    void ispisi(String ime, String prezime) {
        for (Student s : studenti)
            if (s.getIme().equals(ime) && s.getPrezime().equals(prezime))
                studenti.remove(s);
    }
    public ArrayList<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(ArrayList<Student> studenti) {
        this.studenti = studenti;
    }
}
