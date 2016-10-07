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
                    if (args.length < 3) {
                        fm.show();
                    }
                    else {
                        fm.show(Integer.parseInt(args[2]));
                    }
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
                    break;

                case "del":
                    fm.del(Integer.parseInt(args[2]));
                    break;

                case "count":
                    if (args.length < 3) {
                        fm.count();
                    }
                    else {
                        if (args[2].equals("pkw")) fm.countPKW();
                        if (args[2].equals("lkw")) fm.countLKW();
                    }
                    break;

                case "meanprice":
                    if (args.length < 3) {
                        fm.meanprice();
                    }
                    else {
                        if (args[2].equals("pkw")) fm.meanpricePKW();
                        if (args[2].equals("lkw")) fm.meanpriceLKW();
                    }
                    break;

                case "meanage":
                    fm.meanage();
                    break;

                case "oldest":
                    fm.oldest();
                    break;

                default:
                    showHelp();
                    break;

            }

        }
    }

    public static void showHelp() {
        System.out.println("Usage: Fahrzeugclient <Datanquelle> <Parameter>");
        System.out.println("show");
        System.out.println("show <id>");
        System.out.println("add lkw <id> <marke> <modell> <baujahr> <grundpreis>");
        System.out.println("add pkw <id> <marke> <modell> <baujahr> <grundpreis> <ueberpruefungsdatum>");
        System.out.println("del <id>");
        System.out.println("count");
        System.out.println("count <type>");
        System.out.println("meanprice");
        System.out.println("meanprice <type>");
        System.out.println("meanage");
        System.out.println("oldest");
    }

}
