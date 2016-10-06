package at.ac.univie.swe2016.fm.fahrzeuge.dao;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializedFahrzeugDAO implements FahrzeugDAO {

    private String path = "";

    public SerializedFahrzeugDAO(String path) {
        this.path = path;
    }

    public List getFahrzeugList() {
        List<Fahrzeug> list = new ArrayList<>();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));

            while (true) {
                try {
                    list.add((Fahrzeug) in.readObject());
                } catch (ClassNotFoundException e) {
                    in.close();
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Fahrzeug getFahrzeugbyId(int id) {
        List<Fahrzeug> list = new ArrayList<Fahrzeug>(this.getFahrzeugList());

        //list = this.getFahrzeugList();

        for (Fahrzeug f : list) {
            if (f.getId() == id) return f;
        }

        return null;
    }

    public void speichereFahrzeug(Fahrzeug f) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(f);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loescheFahrzeug(Fahrzeug f) {

    }

}
