package at.ac.univie.swe2016.fm;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
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

    public void del() {

    }

    public void count() {

    }

    public void countPKW() {

    }

    public void countLKW() {

    }
}
