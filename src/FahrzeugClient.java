import at.ac.univie.swe2016.fm.FahrzeugManagement;
import at.ac.univie.swe2016.fm.fahrzeuge.Fahrzeug;
import at.ac.univie.swe2016.fm.fahrzeuge.LKW;
import at.ac.univie.swe2016.fm.fahrzeuge.PKW;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Frontend. Verarbeitung und Validierung der Konsolenargumente und -parameter.
 *
 * @author Christian Rauch, 1202875
 */

public class FahrzeugClient {

    public static void main(String[] args) {

        try {

            if (args.length < 2) {
                showHelp();
            } else {

                FahrzeugManagement fm = new FahrzeugManagement(args[0]);

                switch (args[1]) {

                    case "show":
                        if (args.length < 3) {
                            fm.show();
                        } else {
                            fm.show(Integer.parseInt(args[2]));
                        }
                        break;

                    case "add":
                        if (args[2].equals("pkw")) {
                            GregorianCalendar cal = new GregorianCalendar();
                            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

                                cal.setTime(format1.parse(args[8]));
                                PKW pkw = new PKW(args[4], args[5], Integer.parseInt(args[6]), Double.parseDouble(args[7]), Integer.parseInt(args[3]), cal);
                                fm.add(pkw);


                        } else if (args[2].equals("lkw")) {
                            LKW lkw = new LKW(args[4], args[5], Integer.parseInt(args[6]), Double.parseDouble(args[7]), Integer.parseInt(args[3]));
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
                        } else {
                            if (args[2].equals("pkw")) fm.countPKW();
                            if (args[2].equals("lkw")) fm.countLKW();
                        }
                        break;

                    case "meanprice":
                        if (args.length < 3) {
                            fm.meanprice();
                        } else {
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

        } catch(IOException e) {
            System.out.println("Quelldatei konnte nicht gefunden werden!");
            System.exit(1);
        } catch(NullPointerException e) {
            System.out.println("Fahrzeug konnte nicht gefunden werden!");
            System.exit(2);
        } catch(ParseException|NumberFormatException|ArrayIndexOutOfBoundsException e) {
            System.out.println("Ungültige Eingabe!");
            System.exit(3);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(4);
        }
    }

    /**
     * Zeigt Usage-Help und Liste der m&ouml;glichen Parameter
     *
     */

    public static void showHelp() {
        System.out.println("Usage: Fahrzeugclient <Datanquelle> <Parameter>\n");
        System.out.println("Parameter:");
        System.out.println("\tshow");
        System.out.println("\tshow <id>");
        System.out.println("\tadd lkw <id> <marke> <modell> <baujahr> <grundpreis>");
        System.out.println("\tadd pkw <id> <marke> <modell> <baujahr> <grundpreis> <ueberpruefungsdatum>");
        System.out.println("\tdel <id>");
        System.out.println("\tcount");
        System.out.println("\tcount <type>");
        System.out.println("\tmeanprice");
        System.out.println("\tmeanprice <type>");
        System.out.println("\tmeanage");
        System.out.println("\toldest");
    }

}
