package at.ac.univie.swe2016.fm.fahrzeuge;

import java.io.Serializable;
import java.time.Year;

/**
 * Grundlegende Eigenschaften und Methoden für Fahrzeuge.
 *
 * @author Christian Rauch, 1202875
 */

public abstract class Fahrzeug implements Serializable {

    private String marke;
    private String modell;
    private int baujahr;
    private double grundpreis;
    private int id;

    // constructors

    public Fahrzeug() {}

    public Fahrzeug(String marke, String modell, int baujahr, double grundpreis, int id) {
        this.marke = marke;
        this.modell = modell;
        this.baujahr = baujahr;
        this.grundpreis = grundpreis;
        this.id = id;
    }

    // getters and setters

    public String getMarke() { return marke; }

    public String getModell() {
        return modell;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public double getGrundpreis() { return grundpreis; }

    public int getId() {
        return id;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    public void setGrundpreis(int grundpreis) {
        this.grundpreis = grundpreis;
    }

    public void setId(int id) {
        this.id = id;
    }

    // methods

    public abstract int getRabatt();

    /**
     * Berechnet den aktuellen Fahrzeugpreis.
     *
     * @author Christian Rauch, 1202875
     * @return aktueller Fahrzeugpreis
     */

    public double getPreis() {
        return (this.grundpreis * ((100 - (double) this.getRabatt()) / 100) );
    }

    /**
     * Berechnet das aktuelle Alter des Fahrzeuges.
     *
     * @author Christian Rauch, 1202875
     * @return aktuelles Alter des Fahrzeuges
     */

    public int getAlter() {
        return (Year.now().getValue() - this.baujahr);
    }

}