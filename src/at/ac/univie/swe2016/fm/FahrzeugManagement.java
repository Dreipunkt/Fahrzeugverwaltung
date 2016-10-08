package at.ac.univie.swe2016.fm;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import at.ac.univie.swe2016.fm.fahrzeuge.LKW;
import at.ac.univie.swe2016.fm.fahrzeuge.PKW;
import at.ac.univie.swe2016.fm.fahrzeuge.dao.FahrzeugDAO;
import at.ac.univie.swe2016.fm.fahrzeuge.dao.SerializedFahrzeugDAO;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementiert die Logik zur Fahrzeugverwaltung.
 *
 * @author Christian Rauch, 1202875
 */

public class FahrzeugManagement {

    private FahrzeugDAO fahrzeugDAO;
    private DecimalFormat df;

    public FahrzeugManagement() {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
        otherSymbols.setDecimalSeparator('.');
        df = new DecimalFormat("#0.00", otherSymbols);
    }

    /**
     * Hauptkonstruktor der Klasse.
     *
     * @author Christian Rauch, 1202875
     * @param path Pfad bzw. Dateiname, wo persistent gearbeitet werden soll
     */

    public FahrzeugManagement(String path) {
        fahrzeugDAO = new SerializedFahrzeugDAO(path);
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
        otherSymbols.setDecimalSeparator('.');
        df = new DecimalFormat("#0.00");
    }

    public FahrzeugDAO getFahrzeugDAO() {
        return fahrzeugDAO;
    }

    public void setFahrzeugDAO(FahrzeugDAO fahrzeugDAO) {
        this.fahrzeugDAO = fahrzeugDAO;
    }

    /**
     * Gibt eine Liste aller Fahrzeuge aus.
     *
     * @author Christian Rauch, 1202875
     */

    public void show() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        for (Fahrzeug f : l) {
            System.out.println(f);
        }
    }

    /**
     * Gibt ein bestimmtes Fahrzeug aus.
     *
     * @author Christian Rauch, 1202875
     * @param id ID des auszugebenden Fahrzeuges
     */

    public void show(int id) {
        System.out.println(fahrzeugDAO.getFahrzeugbyId(id));
    }

    /**
     * F&uuml;gt ein Fahrzeug persistent hinzu.
     *
     * @author Christian Rauch, 1202875
     * @param f Fahrzeug, das hinzugef&uuml;gt werden soll
     */

    public void add(Fahrzeug f) {
        fahrzeugDAO.speichereFahrzeug(f);
    }

    /**
     * L&ouml;scht ein Fahrzeug persistent.
     *
     * @author Christian Rauch, 1202875
     * @param id ID des zu l&ouml;schenden Fahrzeuges
     */

    public void del(int id) {
        Fahrzeug f = fahrzeugDAO.getFahrzeugbyId(id);
        fahrzeugDAO.loescheFahrzeug(f);
    }

    /**
     * Gibt die Anzahl aller gespeicherten Fahrzeuge aus.
     *
     * @author Christian Rauch, 1202875
     */

    public void count() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        System.out.println(l.size());
    }

    /**
     * Gibt die Anzahl aller gespeicherten PKW aus.
     *
     * @author Christian Rauch, 1202875
     */

    public void countPKW() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        int i = 0;
        for (Fahrzeug f : l) {
            if (f instanceof PKW) i++;
        }
        System.out.println(i);
    }

    /**
     * Gibt die Anzahl aller gespeicherten LKW aus.
     *
     * @author Christian Rauch, 1202875
     */

    public void countLKW() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        int i = 0;
        for (Fahrzeug f : l) {
            if (f instanceof LKW) i++;
        }
        System.out.println(i);
    }

    /**
     * Berechnet den durchschnittlichen Preis aller gespeicherten Fahrzeuge und gibt es aus.
     *
     * @author Christian Rauch, 1202875
     */

    public void meanprice() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        double sum = 0;
        for (Fahrzeug f : l) {
            sum += f.getPreis();
        }
        System.out.println(df.format(sum / l.size()));
    }

    /**
     * Berechnet den durchschnittlichen Preis aller gespeicherten PKW und gibt es aus.
     *
     * @author Christian Rauch, 1202875
     */

    public void meanpricePKW() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        double sum = 0;
        int i = 0;
        for (Fahrzeug f : l) {
            if (f instanceof PKW) {
                i++;
                sum += f.getPreis();
            }
        }
        if (i < 1) System.out.println(0);
        else System.out.println(df.format(sum / i));
    }

    /**
     * Berechnet den durchschnittlichen Preis aller gespeicherten LKW und gibt es aus.
     *
     * @author Christian Rauch, 1202875
     */

    public void meanpriceLKW() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        double sum = 0;
        int i = 0;
        for (Fahrzeug f : l) {
            if (f instanceof LKW) {
                i++;
                sum += f.getPreis();
            }
        }
        if (i < 1) System.out.println(0);
        else System.out.println(df.format(sum / i));
    }

    /**
     * Berechnet das durchschnittliche Alter aller gespeicherten Fahrzeuge und gibt es aus.
     *
     * @author Christian Rauch, 1202875
     */

    public void meanage() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        double sum = 0;
        for (Fahrzeug f : l) {
            sum += f.getAlter();
        }
        System.out.println(df.format(sum / l.size()));
    }

    /**
     * Findet das bzw. die &auml;ltesten Fahrzeuge und gibt sie aus.
     *
     * @author Christian Rauch, 1202875
     */

    public void oldest() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        int max = 0;
        for (Fahrzeug f : l) {
            if (f.getAlter() > max) max = f.getAlter();
        }
        for (Fahrzeug f : l) {
            if (f.getAlter() < max) l.remove(f);
        }
        for (Fahrzeug f : l) {
            System.out.println(f);
        }
    }
}
