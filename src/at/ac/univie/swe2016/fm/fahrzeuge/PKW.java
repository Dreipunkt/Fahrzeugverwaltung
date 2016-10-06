package at.ac.univie.swe2016.fm.fahrzeuge;

import java.util.Date;

public class PKW extends Fahrzeug {

    private Date lastCheckDate;

    public PKW(String marke, String modell, int baujahr, int grundpreis, Date lastCheckDate) {
        super(marke, modell, baujahr, grundpreis);
        this.lastCheckDate = lastCheckDate;
    }

    public Date getLastCheckDate() {
        return lastCheckDate;
    }

    public void setLastCheckDate(Date lastCheckDate) {
        this.lastCheckDate = lastCheckDate;
    }

    public int getRabatt() {
        return 0;
    }

    public String toString() {
        return "";
    }

}
