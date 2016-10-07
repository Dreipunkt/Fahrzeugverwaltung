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

public class FahrzeugManagement {

    private FahrzeugDAO fahrzeugDAO;
    private DecimalFormat df;

    public FahrzeugManagement() {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
        otherSymbols.setDecimalSeparator('.');
        df = new DecimalFormat("#0.00", otherSymbols);
    }

    public FahrzeugManagement(String path) {
        fahrzeugDAO = new SerializedFahrzeugDAO(path);
        df = new DecimalFormat("#0.00");
    }

    public FahrzeugDAO getFahrzeugDAO() {
        return fahrzeugDAO;
    }

    public void setFahrzeugDAO(FahrzeugDAO fahrzeugDAO) {
        this.fahrzeugDAO = fahrzeugDAO;
    }

    public void show() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        for (Fahrzeug f : l) {
            System.out.println(f);
        }
    }

    public void show(int id) {
        System.out.println(fahrzeugDAO.getFahrzeugbyId(id));
    }

    public void add(Fahrzeug f) {
        fahrzeugDAO.speichereFahrzeug(f);
    }

    public void del(int id) {
        Fahrzeug f = fahrzeugDAO.getFahrzeugbyId(id);
        fahrzeugDAO.loescheFahrzeug(f);
    }

    public void count() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        System.out.println(l.size());
    }

    public void countPKW() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        int i = 0;
        for (Fahrzeug f : l) {
            if (f instanceof PKW) i++;
        }
        System.out.println(i);
    }

    public void countLKW() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        int i = 0;
        for (Fahrzeug f : l) {
            if (f instanceof LKW) i++;
        }
        System.out.println(i);
    }

    public void meanprice() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        double sum = 0;
        for (Fahrzeug f : l) {
            sum += f.getPreis();
        }
        System.out.println(df.format(sum / l.size()));
    }

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

    public void meanage() {
        List<Fahrzeug> l = new ArrayList<>(fahrzeugDAO.getFahrzeugList());
        double sum = 0;
        for (Fahrzeug f : l) {
            sum += f.getAlter();
        }
        System.out.println(df.format(sum / l.size()));
    }

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
