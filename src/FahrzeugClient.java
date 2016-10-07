import at.ac.univie.swe2016.fm.FahrzeugManagement;
import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import at.ac.univie.swe2016.fm.fahrzeuge.LKW;
import at.ac.univie.swe2016.fm.fahrzeuge.PKW;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FahrzeugClient {

    public static void main(String[] args) {

        if (args.length < 2) {
            showHelp();
        } else {

            FahrzeugManagement fm = new FahrzeugManagement(args[0]);

            switch (args[1]) {
                case "show":
                    fm.show();
                    break;
                case "add":
                    if (args[2].equals("pkw")) {
                        GregorianCalendar cal = new GregorianCalendar();
                        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            cal.setTime(format1.parse(args[8]));
                            PKW pkw = new PKW(args[4], args[5], Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[3]), cal);
                            fm.add(pkw);
                        } catch (ParseException e) {
                            System.out.println(e.toString());
                        }

                    } else if (args[2].equals("lkw")) {
                        LKW lkw = new LKW(args[4], args[5], Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[3]));
                        fm.add(lkw);
                    } else {
                        showHelp();
                    }
            }

        }
    }

    public static void showHelp() {
        System.out.println("Usage: Fahrzeugclient <Datanquelle> <Parameter>");
        System.out.println("add lkw <id> <marke> <modell> <baujahr> <grundpreis>");
        System.out.println("add pkw <id> <marke> <modell> <baujahr> <grundpreis> <ueberpruefungsdatum>");
    }

}
