package com.example.lv07.controller;

import com.example.lv07.model.Osoba;
import com.example.lv07.model.OsobaModel;
import com.example.lv07.view.OsobaView;

import java.util.Iterator;
import java.util.List;

public class OsobaController {
    private OsobaModel model;
    private OsobaView view;


    public OsobaController(OsobaModel model, OsobaView view) {
        this.model = model;
        this.view = view;
    }

    public Osoba dajOsobuPoId(Integer id) {
        if(model.dajOsobuPoId(id)==null)view.setPoruka("Osoba nije pronadjena!");
        else view.setPoruka(model.dajOsobuPoId(id).toString());
        return model.dajOsobuPoId(id);

    }


    public void azurirajIme(Integer id) {
        try {
            model.azurirajOsobu(id, view.getUlazniTekst(), null, null, null, null, null);
            view.setPoruka("Ime je uspjesno azurirano!");
        } catch (Exception e) {

        view.setPoruka("Greska: " + e.getMessage());
    }
}
    public void dajOsobeIzTxtDatoteke(String filePath) {
        try {
            model.napuniPodatkeIzTxtDatoteke(filePath);
            String poruka = "Osobe ucitane iz txt datoteke su:\n";

            Osoba osoba;
            for(Iterator var4 = model.dajSveOsobe().iterator(); var4.hasNext(); poruka = poruka + osoba.toString() + "\n") {
                osoba = (Osoba)var4.next();
            }

            this.view.setPoruka(poruka);
        } catch (Exception var6) {
            Exception e = var6;
            this.view.setPoruka("Greska: " + e.getMessage());
        }

    }

    public void dajOsobeIzXmlDatoteke(String filePath) {
        try {
           model.napuniPodatkeIzXmlDatoteke(filePath);
            String poruka = "Osobe ucitane iz txt datoteke su:\n";

            Osoba osoba;
            for(Iterator var4 = model.dajSveOsobe().iterator(); var4.hasNext(); poruka = poruka + osoba.toString() + "\n") {
                osoba = (Osoba)var4.next();
            }

            this.view.setPoruka(poruka);
        } catch (Exception var6) {
            Exception e = var6;
            this.view.setPoruka("Greska: " + e.getMessage());
        }

    }

}

