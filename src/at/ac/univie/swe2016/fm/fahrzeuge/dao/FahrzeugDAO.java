package at.ac.univie.swe2016.fm.fahrzeuge.dao;

import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;

import java.util.List;

public interface FahrzeugDAO {

    List getFahrzeugList();

    Fahrzeug getFahrzeugbyId(int id);

    void speichereFahrzeug(Fahrzeug f);

    void loescheFahrzeug(Fahrzeug f);

}
