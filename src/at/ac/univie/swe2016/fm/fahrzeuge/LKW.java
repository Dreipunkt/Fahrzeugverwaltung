package at.ac.univie.swe2016.fm.fahrzeuge;

public class LKW extends Fahrzeug {

    public LKW(String marke, String modell, int baujahr, int grundpreis) {
        super(marke, modell, baujahr, grundpreis);
    }

    public int getRabatt() {
        return 0;
    }

    public String toString() {
        return "";
    }

}
