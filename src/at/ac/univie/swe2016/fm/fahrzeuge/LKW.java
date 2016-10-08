package at.ac.univie.swe2016.fm.fahrzeuge;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Year;

/**
 * Erweitert Fahrzeug um LKW spezifische Eigenschaften und Methoden.
 *
 * @author Christian Rauch, 1202875
 */

public class LKW extends Fahrzeug {

    /**
     * Konstruktor f&uuml;r LKW.
     *
     * @author Christian Rauch, 1202875
     * @param marke Die Marke des LKW.
     * @param modell Das Modell des LKW.
     * @param baujahr Das Baujahr des LKW.
     * @param grundpreis Der Grundpreis des LKW.
     * @param id Die eindeutige ID, die dem LKW zugeordnet werden soll.
     */

    public LKW(String marke, String modell, int baujahr, double grundpreis, int id) {
        super(marke, modell, baujahr, grundpreis, id);
    }

    /**
     * Berechnet den Rabatt f&uuml;r einen LKW. Pro Jahr werden 5% Rabatt vergeben, bis zu einem Maximum von 20%.
     *
     * @author Christian Rauch, 1202875
     * @return Rabatt als Prozentwert * 100. Beispiel: 5% Rabatt - returns 5
     */

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
