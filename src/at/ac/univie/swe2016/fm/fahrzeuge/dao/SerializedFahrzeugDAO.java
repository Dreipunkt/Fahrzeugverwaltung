package at.ac.univie.swe2016.fm.fahrzeuge.dao;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Enthält Methoden zur Serialisierung.
 *
 * @author Christian Rauch, 1202875
 */

public class SerializedFahrzeugDAO implements FahrzeugDAO {

    private String path = "";

    /**
     * Konstruktor der Klasse.
     *
     * @author Christian Rauch, 1202875
     * @param path Pfad bzw. Dateiname, wo persistent gearbeitet werden soll
     */

    public SerializedFahrzeugDAO(String path) {
        this.path = path;
    }

    /**
     * Erstellt eine Liste aller gespeicherten Fahrzeuge.
     *
     * @author Christian Rauch, 1202875
     * @return Liste aller gespeicherten Fahrzeuge
     */

    public List<Fahrzeug> getFahrzeugList() {
        List<Fahrzeug> list = new ArrayList<>();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));

            while (true) {
                try {
                    list.add((Fahrzeug) in.readObject());
                } catch (EOFException e) {
                    in.close();
                    break;
                } catch (ClassNotFoundException e) {
                    System.out.println(e.toString());
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return list;
    }

    /**
     * Findet ein Fahrzeug per eindeutiger ID.
     *
     * @author Christian Rauch, 1202875
     * @return Fahrzeug mit jeweiliger ID
     * @param id ID des gesuchten Fahrzeugs
     */

    public Fahrzeug getFahrzeugbyId(int id) {
        List<Fahrzeug> list = new ArrayList<>(this.getFahrzeugList());

        for (Fahrzeug f : list) {
            if (f.getId() == id) return f;
        }

        return null;
    }

    /**
     * Speichert ein Fahrzeug persistent ab.
     *
     * @author Christian Rauch, 1202875
     * @param f Fahrzeug, das gespeichert werden soll
     */

    public void speichereFahrzeug(Fahrzeug f) {
        try {
            if (getFahrzeugbyId(f.getId()) != null) {
                System.out.println("Fahrzeug mit dieser ID schon vorhanden!");
                return;
            }
            List<Fahrzeug> list = new ArrayList<>(this.getFahrzeugList());
            FileOutputStream fout = new FileOutputStream(path);
            ObjectOutputStream oout = new ObjectOutputStream(fout);

            for (Fahrzeug o : list) { oout.writeObject(o); }
            oout.writeObject(f);

            oout.close();
            fout.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * L&ouml;scht ein Fahrzeug aus der persistenten Speicherung
     *
     * @author Christian Rauch, 1202875
     * @param f Fahrzeug, das gel&ouml;scht werden soll
     */

    public void loescheFahrzeug(Fahrzeug f) {
        List<Fahrzeug> list = new ArrayList<>(this.getFahrzeugList());

        try {
            FileOutputStream fout = new FileOutputStream(path);
            ObjectOutputStream oout = new ObjectOutputStream(fout);

            for (Fahrzeug o : list) {
                if (f.getId() != o.getId()) {
                    oout.writeObject(o);
                }
            }
            oout.close();
            fout.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }


    }

}
