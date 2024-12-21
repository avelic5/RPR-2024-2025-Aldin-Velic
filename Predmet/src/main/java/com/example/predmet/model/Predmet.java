package com.example.predmet.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Predmet {
    private StringProperty naziv = new SimpleStringProperty();
    private DoubleProperty ECTS = new SimpleDoubleProperty();

    public Predmet(Double ECTS, String naziv) {
        setECTS(ECTS);
        setNaziv(naziv);
    }

    public Double getECTS() {
        return ECTS.get();
    }

    public void setECTS(Double ECTS) {
        if (ECTS < 5.0 || ECTS > 20.0) throw new IllegalArgumentException("GR");
        if ((ECTS * 10) % 10 != 0 && (ECTS * 10) % 10 != 5) throw new IllegalArgumentException("GR");
        this.ECTS.set(ECTS);
    }

    public String getNaziv() {
        return naziv.get();
    }

    public void setNaziv(String naziv) {
        if (naziv.length() < 5 || naziv.length() > 100) throw new IllegalArgumentException("GR");
        this.naziv.set(naziv);
    }

    public StringProperty nazivProperty() {
        return naziv;
    }

    public DoubleProperty ECTSProperty() {
        return ECTS;
    }



    @Override
    public String toString() {
        return "Predmet{" +
                "ECTS=" + ECTS.get() +
                ", naziv='" + naziv.get() + '\'' +
                '}';
    }
}
