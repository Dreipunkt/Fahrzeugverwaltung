package at.ac.univie.swe2016.fm;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import at.ac.univie.swe2016.fm.fahrzeuge.LKW;
import at.ac.univie.swe2016.fm.fahrzeuge.PKW;
import at.ac.univie.swe2016.fm.fahrzeuge.dao.FahrzeugDAO;
import at.ac.univie.swe2016.fm.fahrzeuge.dao.SerializedFahrzeugDAO;

import java.util.ArrayList;
import java.util.List;

public class FahrzeugManagement {

    private FahrzeugDAO fahrzeugDAO;

    public FahrzeugManagement() {}

    public FahrzeugManagement(String path) {
        fahrzeugDAO = new SerializedFahrzeugDAO(path);
    }

    public FahrzeugDAO getFahrzeugDAO() {
        return fahrzeugDAO;
    }

    public void setFahrzeugDAO(FahrzeugDAO fahrzeugDAO) {
        this.fahrzeugDAO = fahrzeugDAO;
    }

    public void show() {
        List<Fahrzeug> list = new ArrayList<Fahrzeug>(fahrzeugDAO.getFahrzeugList());
        for (Fahrzeug f : list) {
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
        List<Fahrzeug> l = fahrzeugDAO.getFahrzeugList();
        System.out.println(l.size());
    }

    public void countPKW() {
        List<Fahrzeug> l = fahrzeugDAO.getFahrzeugList();
        int i = 0;
        for (Fahrzeug f : l) {
            if (f instanceof PKW) i++;
        }
        System.out.println(i);
    }

    public void countLKW() {
        List<Fahrzeug> l = fahrzeugDAO.getFahrzeugList();
        int i = 0;
        for (Fahrzeug f : l) {
            if (f instanceof LKW) i++;
        }
        System.out.println(i);
    }
}
