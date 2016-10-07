package at.ac.univie.swe2016.fm.fahrzeuge.dao;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;

import java.util.List;

/**
 * Interface zur Serialisierung. Methoden werden in SerializedFahrzeugDAO implementiert.
 *
 * @author Christian Rauch, 1202875
 */

public interface FahrzeugDAO {

    List<Fahrzeug> getFahrzeugList();

    Fahrzeug getFahrzeugbyId(int id);

    void speichereFahrzeug(Fahrzeug f);

    void loescheFahrzeug(Fahrzeug f);

}
