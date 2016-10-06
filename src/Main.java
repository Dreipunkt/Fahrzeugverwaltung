import at.ac.univie.swe2016.fm.fahrzeuge.LKW;
import at.ac.univie.swe2016.fm.fahrzeuge.PKW;

import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {

        PKW pkw1 = new PKW("Tesla Motors", "Model S", 2014, 70500, new GregorianCalendar(2015, 7, 23));     // months start with 0 !!!

        LKW lkw1 = new LKW("MAN", "TGX", 2004, 50000);

        System.out.println(pkw1);
        System.out.println("");
        System.out.println(lkw1);
    }

}
