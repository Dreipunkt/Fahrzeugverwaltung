package at.ac.univie.swe2016.fm.fahrzeuge;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Year;

public class LKW extends Fahrzeug {

    public LKW(String marke, String modell, int baujahr, double grundpreis, int id) {
        super(marke, modell, baujahr, grundpreis, id);
    }

    public int getRabatt() {
        int per = (Year.now().getValue() - this.getBaujahr()) * 5;
        return (per > 20) ? 20 : per;
    }

    public String toString() {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#0.00", otherSymbols);

        String s = "";
        s += "Typ:\tLKW\n";
        s += "Id:\t" + this.getId() + "\n";
        s += "Marke:\t" + this.getMarke() + "\n";
        s += "Modell:\t" + this.getModell() + "\n";
        s += "Baujahr:\t" + this.getBaujahr() + "\n";
        s += "Grundpreis:\t" + df.format(this.getGrundpreis()) + "\n";
        s += "Preis:\t" + df.format(this.getPreis()) + "\n";
        return s;
    }

}
