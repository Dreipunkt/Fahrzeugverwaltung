package at.ac.univie.swe2016.fm.fahrzeuge.dao;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;

import java.util.List;

/**
 * Interface zur Serialisierung. Methoden werden in SerializedFahrzeugDAO implementiert.
 *
 * @author Christian Rauch, 1202875
 */

public interface FahrzeugDAO {

    /**
     * Erstellt eine Liste aller gespeicherten Fahrzeuge.
     *
     * @author Christian Rauch, 1202875
     * @return Liste aller gespeicherten Fahrzeuge
     */

    List<Fahrzeug> getFahrzeugList();

    /**
     * Findet ein Fahrzeug per eindeutiger ID.
     *
     * @author Christian Rauch, 1202875
     * @return Fahrzeug mit jeweiliger ID
     * @param id ID des gesuchten Fahrzeugs
     */

    Fahrzeug getFahrzeugbyId(int id);

    /**
     * Speichert ein Fahrzeug persistent ab.
     *
     * @author Christian Rauch, 1202875
     * @param f Fahrzeug, das gespeichert werden soll
     */

    void speichereFahrzeug(Fahrzeug f);

    /**
     * L&ouml;scht ein Fahrzeug aus der persistenten Speicherung
     *
     * @author Christian Rauch, 1202875
     * @param f Fahrzeug, das gel&ouml;scht werden soll
     */

    void loescheFahrzeug(Fahrzeug f);

}
