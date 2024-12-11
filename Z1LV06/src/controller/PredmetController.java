package controller;

import model.Osoba;
import model.Predmet;
import view.OsobaView;

import java.util.List;

public class PredmetController {
    private OsobaView view;
    private Predmet predmet;

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public OsobaView getView() {
        return view;
    }

    public void setView(OsobaView view) {
        this.view = view;
    }
    public PredmetController(Predmet model, OsobaView view) {
        this.predmet = model;
        this.view = view;
    }
   public void azuriraj(){
        try {
            String[]s=view.getUlazniTekst().split(",");
            predmet.setNaziv(s[0]);
            predmet.setECTS(Double.valueOf(s[1]));
            view.setPoruka("Ime i ECTS su uspjesno azurirani!");
        }
        catch(Exception e) {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }
    public void dajPredmeteIzTxtDatoteke(String filePath)
    {
        try
        {
            List<Predmet> predmeti = Predmet.ucitajPredmeteIzTxtDatoteke(filePath);
            String poruka = "Predmeti ucitani iz txt datoteke su:\n";
            for (Predmet predmet : predmeti)
            {
                poruka += predmet.toString() + "\n";
            }
            view.setPoruka(poruka);
        }
        catch(Exception e)
        {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }


}
