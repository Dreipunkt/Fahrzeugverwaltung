package at.ac.univie.swe2016.fm.fahrzeuge;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PKW extends Fahrzeug {

    private GregorianCalendar lastCheckDate;

    public PKW(String marke, String modell, int baujahr, double grundpreis, int id, GregorianCalendar lastCheckDate) {
        super(marke, modell, baujahr, grundpreis, id);
        this.lastCheckDate = lastCheckDate;
    }

    public GregorianCalendar getLastCheckDate() {
        return lastCheckDate;
    }

    public void setLastCheckDate(GregorianCalendar lastCheckDate) {
        this.lastCheckDate = lastCheckDate;
    }

    public int getRabatt() {
        int per1 = (Year.now().getValue() - this.getBaujahr()) * 5;
        int per2 = (GregorianCalendar.getInstance().get(Calendar.YEAR) - this.lastCheckDate.get(Calendar.YEAR)) * 2;
        int per = per1 + per2;
        return (per > 15) ? 15 : per;
    }

    public String toString() {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#0.00", otherSymbols);

        String s = "";
        s += "Typ:\tPKW\n";
        s += "Id:\t" + this.getId() + "\n";
        s += "Marke:\t" + this.getMarke() + "\n";
        s += "Modell:\t" + this.getModell() + "\n";
        s += "Baujahr:\t" + this.getBaujahr() + "\n";
        s += "Grundpreis:\t" + df.format(this.getGrundpreis()) + "\n";

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        format1.setCalendar(this.getLastCheckDate());

        s += "Überprüfungsdatum:\t" + format1.format(this.getLastCheckDate().getTime()) + "\n";
        s += "Preis:\t" + df.format(this.getPreis()) + "\n";
        return s;
    }

}
