public abstract class Fahrzeug {
    private static int currentID = 0;
    private String marke;
    private String modell;
    private int baujahr;
    private int grundpreis;
    private int id;

    // constructor

    public Fahrzeug() {

    }

    public Fahrzeug(String marke, String modell, int baujahr, int grundpreis) {
        this.marke = marke;
        this.modell = modell;
        this.baujahr = baujahr;
        this.grundpreis = grundpreis;
        this.id = currentID++;
    }

    // standard getters and setters

    public String getMarke() {
        return marke;
    }

    public String getModell() {
        return modell;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public int getGrundpreis() {
        return grundpreis;
    }

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


}