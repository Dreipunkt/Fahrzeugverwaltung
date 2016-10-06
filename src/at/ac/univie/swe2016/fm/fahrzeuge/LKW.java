package at.ac.univie.swe2016.fm.fahrzeuge;

import java.time.Year;

public class LKW extends Fahrzeug {

    public LKW(String marke, String modell, int baujahr, int grundpreis) {
        super(marke, modell, baujahr, grundpreis);
    }

    public int getRabatt() {
        int per = (Year.now().getValue() - this.getBaujahr()) * 5;
        return (per > 20) ? 20 : per;
    }

    public String toString() {
        String s = "";
        s += "Typ:\tLKW\n";
        s += "Id:\t" + this.getId() + "\n";
        s += "Marke:\t" + this.getMarke() + "\n";
        s += "Modell:\t" + this.getModell() + "\n";
        s += "Baujahr:\t" + this.getBaujahr() + "\n";
        s += "Grundpreis:\t" + this.getGrundpreis() + "\n";
        s += "Preis:\t" + this.getPreis() + "\n";
        return s;
    }

}
