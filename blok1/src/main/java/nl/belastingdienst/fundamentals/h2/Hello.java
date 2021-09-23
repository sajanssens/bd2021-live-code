package nl.belastingdienst.fundamentals.h2;

import static java.lang.Math.cos;

/**
 * Mijn eerste klasse.
 *
 * @author bramj
 * @since 1.0
 */
public class Hello {

    private final double PI = 3.14;

    public static int verdubbel(int getal) {
        return getal * 2;
    }

    /**
     * Het startpunt van onze applicatie
     *
     * @param args de command line argumenten die je meegeeft; ....
     */
    public static void main(String[] args) {
        // <type> identifier       declareren: één maal in de huidige scope ({...})
        int plusTwo;
        plusTwo = Math.abs(-2); // schrijven
        int i = plusTwo;        // lezen

        int resultaat1 = verdubbel(45);
        int resultaat2 = verdubbel(i);

        System.out.println(args[0]);
        System.out.println(args[1]); // CTRL D = duplicate line
        System.out.println(args[2]);

        plusTwo = Math.abs(-4);

        double result = cos(Math.PI * 1.23);
        double result2 = cos(Math.PI * 1.3);
        double result3 = cos(Math.PI * 3);
    }

}
