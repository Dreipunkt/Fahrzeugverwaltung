package at.ac.univie.swe2016.fm.fahrzeuge.dao;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;

import java.io.IOException;
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
     * @return Liste aller gespeicherten Fahrzeuge
     * @throws IOException
     */

    List<Fahrzeug> getFahrzeugList() throws IOException;

    /**
     * Findet ein Fahrzeug per eindeutiger ID.
     *
     * @return Fahrzeug mit jeweiliger ID
     * @param id ID des gesuchten Fahrzeugs
     * @throws IOException
     */

    Fahrzeug getFahrzeugbyId(int id) throws IOException;

    /**
     * Speichert ein Fahrzeug persistent ab.
     *
     * @param f Fahrzeug, das gespeichert werden soll
     * @throws IOException
     * @throws IllegalArgumentException
     */

    void speichereFahrzeug(Fahrzeug f) throws IllegalArgumentException, IOException;

    /**
     * L&ouml;scht ein Fahrzeug aus der persistenten Speicherung
     *
     * @param f Fahrzeug, das gel&ouml;scht werden soll
     * @throws IOException
     * @throws IllegalArgumentException
     */

    void loescheFahrzeug(Fahrzeug f) throws IllegalArgumentException, IOException;

}
