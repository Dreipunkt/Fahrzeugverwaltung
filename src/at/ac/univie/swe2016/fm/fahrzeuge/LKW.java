package at.ac.univie.swe2016.fm.fahrzeuge;

public class LKW extends Fahrzeug {

    public LKW(String marke, String modell, int baujahr, int grundpreis) {
        super(marke, modell, baujahr, grundpreis);
    }

    public int getRabatt() {
        return 0;
    }

    public String toString() {
        String s = "";
        s += "Typ:\tPKW\n";
        s += "Id:\t" + this.getId() + "\n";
        s += "Marke:\t" + this.getMarke() + "\n";
        s += "Modell:\t" + this.getModell() + "\n";
        s += "Baujahr:\t" + this.getBaujahr() + "\n";
        s += "Grundpreis:\t" + this.getGrundpreis() + "\n";
        s += "Preis:\t" + this.getPreis() + "\n";
        return s;
    }

}
