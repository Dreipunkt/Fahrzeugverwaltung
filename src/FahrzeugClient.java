import at.ac.univie.swe2016.fm.FahrzeugManagement;
import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import at.ac.univie.swe2016.fm.fahrzeuge.LKW;
import at.ac.univie.swe2016.fm.fahrzeuge.PKW;

import java.util.GregorianCalendar;

public class FahrzeugClient {

    public static void main(String[] args) {

        FahrzeugManagement fm = new FahrzeugManagement(args[0]);

        switch (args[1]) {
            case "show":
                fm.show();
                break;
            case "add":
                if (args[2] == "pkw") {

                }
                else if (args[2] == "lkw") {

                }
                else {

                }
        }

    }

}
